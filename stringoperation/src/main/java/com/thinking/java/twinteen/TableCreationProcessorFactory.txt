package com.thinking.java.twinteen;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;

/**
 * @author songjz
 * 
 */
public class TableCreationProcessorFactory implements AnnotationProcessorFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sun.mirror.apt.AnnotationProcessorFactory#getProcessorFor(java.util
	 * .Set, com.sun.mirror.apt.AnnotationProcessorEnvironment)
	 */
	public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> arg0,
			AnnotationProcessorEnvironment env) {
		return new TableCreationProcessor(env);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sun.mirror.apt.AnnotationProcessorFactory#supportedAnnotationTypes()
	 */
	public Collection<String> supportedAnnotationTypes() {
		return Arrays.asList("com.thinking.java.twinteen.DBTable",
				"com.thinking.java.twinteen.Constraints", "com.thinking.java.twinteen.SQLString",
				"com.thinking.java.twinteen.SQLInteger");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#supportedOptions()
	 */
	public Collection<String> supportedOptions() {
		return Collections.emptySet();
	}

	private static class TableCreationProcessor implements AnnotationProcessor {
		private final AnnotationProcessorEnvironment env;
		private String sql = "";

		public TableCreationProcessor(AnnotationProcessorEnvironment env) {
			this.env = env;
		}

		public void process() {
			for (TypeDeclaration typeDec : env.getSpecifiedTypeDeclarations()) {
				typeDec.accept(new TableCreationVisitor());
				sql = sql.substring(0, sql.length() - 1) + ");";
				System.out.println("creation SQL is : \n" + sql);
				sql = "";
			}
		}

		private class TableCreationVisitor extends SimpleDeclarationVisitor {

			@Override
			public void visitClassDeclaration(ClassDeclaration d) {
				DBTable dbTable = d.getAnnotation(DBTable.class);
				String tableName = dbTable.name();
				if (tableName.length() < 1) {
					tableName = d.getSimpleName().toUpperCase();
				}
				sql += "CREATE TABLE " + tableName + " (";
			}

			@Override
			public void visitFieldDeclaration(FieldDeclaration d) {
				String columnName = "";
				if (d.getAnnotation(SQLInteger.class) != null) {
					SQLInteger sInt = d.getAnnotation(SQLInteger.class);
					if (sInt.name().length() < 1) {
						columnName = d.getSimpleName().toUpperCase();
					} else {
						columnName = sInt.name();
					}
					sql += "\n	" + columnName + " INT" + getConstraints(sInt.constraints()) + ",";
				}
				if (d.getAnnotation(SQLString.class) != null) {
					SQLString sString = d.getAnnotation(SQLString.class);
					if (sString.name().length() < 1) {
						columnName = d.getSimpleName().toUpperCase();
					} else {
						columnName = sString.name();
					}
					sql += "\n	" + columnName + " VARCHAR(" + sString.value() + ") "
							+ getConstraints(sString.constraints()) + ",";
				}
			}

			private String getConstraints(Constraints con) {
				String constraints = "";
				if (!con.allowNull()) {
					constraints += " NOT NULL";
				}
				if (con.primaryKey()) {
					constraints += " PRIMARY KEY";
				}
				if (con.unique()) {
					constraints += " UNIQUE";
				}
				return constraints;
			}

		}

	}
}
