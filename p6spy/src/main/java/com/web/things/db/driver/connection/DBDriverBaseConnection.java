package com.web.things.db.driver.connection;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import com.web.things.db.driver.monitor.manager.IDBDriverFactory;

/**
 * @author songjz
 * @time 2013年8月7日
 */
public class DBDriverBaseConnection extends DBDriverBase implements Connection {

	protected Connection realConnetion;

	public DBDriverBaseConnection(IDBDriverFactory factory, Connection realConnetion) {
		this.realConnetion = realConnetion;
		setFactory(factory);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return realConnetion.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return realConnetion.isWrapperFor(iface);
	}

	public Statement createStatement() throws SQLException {
		return realConnetion.createStatement();
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return realConnetion.prepareStatement(sql);
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		return realConnetion.prepareCall(sql);
	}

	public String nativeSQL(String sql) throws SQLException {
		return realConnetion.nativeSQL(sql);
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		realConnetion.setAutoCommit(autoCommit);
	}

	public boolean getAutoCommit() throws SQLException {
		return realConnetion.getAutoCommit();
	}

	public void commit() throws SQLException {
		realConnetion.commit();
	}

	public void rollback() throws SQLException {
		realConnetion.rollback();
	}

	public void close() throws SQLException {
		realConnetion.close();
	}

	public boolean isClosed() throws SQLException {
		return realConnetion.isClosed();
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		return realConnetion.getMetaData();
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
		realConnetion.setReadOnly(readOnly);
	}

	public boolean isReadOnly() throws SQLException {
		return realConnetion.isReadOnly();
	}

	public void setCatalog(String catalog) throws SQLException {
		realConnetion.setCatalog(catalog);
	}

	public String getCatalog() throws SQLException {
		return realConnetion.getCatalog();
	}

	public void setTransactionIsolation(int level) throws SQLException {
		realConnetion.setTransactionIsolation(level);
	}

	public int getTransactionIsolation() throws SQLException {
		return realConnetion.getTransactionIsolation();
	}

	public SQLWarning getWarnings() throws SQLException {
		return realConnetion.getWarnings();
	}

	public void clearWarnings() throws SQLException {
		realConnetion.clearWarnings();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return realConnetion.createStatement(resultSetType, resultSetConcurrency);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return realConnetion.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return realConnetion.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return realConnetion.getTypeMap();
	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		realConnetion.setTypeMap(map);
	}

	public void setHoldability(int holdability) throws SQLException {
		realConnetion.setHoldability(holdability);
	}

	public int getHoldability() throws SQLException {
		return realConnetion.getHoldability();
	}

	public Savepoint setSavepoint() throws SQLException {
		return realConnetion.setSavepoint();
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		return realConnetion.setSavepoint(name);
	}

	public void rollback(Savepoint savepoint) throws SQLException {
		realConnetion.rollback(savepoint);
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		realConnetion.releaseSavepoint(savepoint);
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return realConnetion.createStatement(resultSetType, resultSetConcurrency,
				resultSetHoldability);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		return realConnetion.prepareStatement(sql, resultSetType, resultSetConcurrency,
				resultSetHoldability);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return realConnetion.prepareCall(sql, resultSetType, resultSetConcurrency,
				resultSetHoldability);
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		return realConnetion.prepareStatement(sql, autoGeneratedKeys);
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		return realConnetion.prepareStatement(sql, columnIndexes);
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		return realConnetion.prepareStatement(sql, columnNames);
	}

	public Clob createClob() throws SQLException {
		return realConnetion.createClob();
	}

	public Blob createBlob() throws SQLException {
		return realConnetion.createBlob();
	}

	public NClob createNClob() throws SQLException {
		return realConnetion.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException {
		return realConnetion.createSQLXML();
	}

	public boolean isValid(int timeout) throws SQLException {
		return realConnetion.isValid(timeout);
	}

	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		realConnetion.setClientInfo(name, value);
	}

	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		realConnetion.setClientInfo(properties);
	}

	public String getClientInfo(String name) throws SQLException {
		return realConnetion.getClientInfo(name);
	}

	public Properties getClientInfo() throws SQLException {
		return realConnetion.getClientInfo();
	}

	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		return realConnetion.createArrayOf(typeName, elements);
	}

	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		return realConnetion.createStruct(typeName, attributes);
	}

}
