--******备注：此文件中不需要commit;*****
--本文件为插入96点历史负荷和预测负荷

--插入96点历史负荷
--插入电网00历史负荷开始
--INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
--T0015,T0030,T0045,T0100,T0115,T0130,T0145,
--T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
--T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
--T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
--T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
--T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
--T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
--T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
--T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
--T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
--T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
--T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
--T2400) VALUES ('00','00','20140130',
--1654.1626,1660.1504,1675.566,1634.7833,1646.7188,1649.9647,1631.8542,1614.969,1624.0901,1593.8096,1587.7002,1602.9036,1556.6163,1574.8838,1551.5692,1551.974,1539.379,1561.3958,1571.8405,1551.7598,1547.6317,1579.8746,1560.2089,1640.166,1692.4495,1693.5656,1735.4325,1716.8152,1763.9471,1795.1559,1829.0214,1823.0383,1820.5352,1832.8896,1862.2144,1879.5366,1874.9559,1892.0159,1938.0188,1922.3582,1965.6652,1951.4943,1940.4183,1824.3511,1773.9318,1725.5062,1690.4744,1742.0136,1767.6599,1811.0394,1862.1096,1851.8608,1810.8207,1825.3162,1815.0974,1807.9911,1778.9349,1777.684,1770.0718,1752.8575,1758.5002,1723.4829,1724.1846,1720.6797,1731.7028,1721.3451,1711.2966,1653.7721,1582.498,1561.8405,1531.3704,1515.3031,1500.9498,1506.9094,1514.0914,1523.0687,1513.0157,1518.2343,1508.2717,1498.9369,1479.8633,1483.2675,1465.6479,1467.2368,1498.3533,1500.566,1533.4297,1615.2207,1701.63,1698.0685,1675.0046,1649.7631,1635.3569,1590.6731,1524.7778,1549.7267
--);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000) VALUES ('00','00','20140130',
1654.1626,1660.1504,1675.566,1634.7833,1646.7188,1649.9647,1631.8542,
1614.969,1624.0901,1593.8096,1587.7002,1602.9036,1556.6163,1574.8838,1551.5692,
1551.974,1539.379,1561.3958,1571.8405,1551.7598,1547.6317,1579.8746,1560.2089,
1640.166,1692.4495,1693.5656,1735.4325,1716.8152,1763.9471,1795.1559,1829.0214,
1823.0383,1820.5352,1832.8896,1862.2144,1879.5366,1874.9559,1892.0159,1938.0188,
1922.3582
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('00','00','20140129',
1750.512,1780.314,1786.9226,1775.2384,1745.772,1733.8425,1744.5144,1700.0654,1702.0964,1706.6279,1709.7102,1690.3137,1673.9674,1648.5018,1636.498,1655.7919,1671.049,1676.101,1649.8674,1685.009,1720.5438,1750.608,1822.0494,1844.4993,1852.8049,1879.3717,1882.5032,1902.2379,1956.4534,1995.2576,2060.8276,2077.6794,2121.5339,2092.2231,2163.2742,2126.1289,2122.9436,2113.7429,2155.0481,2166.3865,2187.002,2168.8311,2160.0569,2033.3046,1941.3014,1891.7257,1886.3936,1910.2866,1945.2499,1993.3925,2040.5475,2074.269,2041.6522,2041.7498,2042.3199,2005.8085,1991.4756,2011.8837,2006.9282,1944.7041,1955.0151,1957.3325,1973.2666,1971.2648,1947.0249,1964.9426,1932.5345,1836.0992,1770.4399,1763.6667,1748.8296,1704.3793,1721.5443,1729.2998,1734.7913,1733.7723,1708.79,1686.0563,1670.2789,1672.0929,1640.7103,1639.7234,1645.113,1644.6288,1662.1465,1664.7125,1710.3997,1746.3341,1839.6337,1843.4431,1801.6956,1791.9003,1748.2867,1686.7147,1685.7334,1684.5298
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('00','00','20140128',
1681.0797,1692.6871,1683.8323,1676.6421,1655.856,1634.3203,1642.1914,1644.3521,1631.6428,1612.8271,1627.3976,1605.3634,1573.3436,1604.6842,1601.8058,1598.6929,1578.6962,1585.2157,1596.1467,1598.7108,1664.8204,1727.3329,1745.3359,1774.9116,1796.0754,1810.2585,1822.3953,1845.8185,1926.7247,1932.948,1982.4014,1982.9075,1966.8622,1977.1172,1983.7203,2024.7737,2011.1244,2038.2338,2052.3088,2104.6233,2099.2744,2089.6582,2071.9666,1948.5459,1861.1086,1817.2816,1785.2305,1818.3707,1908.2954,1952.1797,2002.4506,2000.8899,1995.7554,1972.3115,1962.074,1994.2361,1969.2511,1973.1324,1948.1084,1939.5641,1924.7057,1947.1826,1926.2606,1953.754,1962.6581,1939.7675,1923.3105,1824.1147,1759.238,1738.1458,1718.7118,1679.04,1691.3376,1697.2897,1698.5386,1688.4474,1685.7773,1675.9901,1661.7565,1672.3492,1668.0487,1647.5581,1650.9032,1673.603,1689.0961,1711.0039,1747.2654,1796.1837,1896.5045,1883.4236,1860.6079,1847.8942,1825.2406,1792.3645,1757.3177,1719.1476
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('00','00','20140127',
1677.1005,1706.1422,1686.0245,1685.8542,1700.3921,1673.4642,1635.7845,1645.1459,1633.7869,1629.8656,1630.327,1619.6824,1598.9355,1622.1416,1608.8364,1609.5071,1607.0699,1592.5786,1616.7352,1653.9546,1680.9113,1722.4832,1758.6343,1780.4092,1839.7854,1846.2415,1847.2179,1869.8744,1924.8495,1932.0261,1985.1617,1993.7382,2018.3292,2030.7467,2031.6879,2038.4979,2058.6494,2049.7192,2085.0168,2118.2205,2134.8037,2110.095,2109.3013,1991.9857,1873.77,1803.6256,1821.8365,1848.5076,1930.994,1986.2538,2028.0199,2029.9077,1999.9575,2040.993,1999.7996,2014.8853,2004.8904,1996.0299,1965.8986,1957.2197,1981.3645,1983.6285,1958.5068,1947.1855,1978.0295,1943.2578,1916.1104,1824.0371,1783.7291,1764.0688,1758.7587,1733.2729,1713.12,1709.9556,1721.5315,1705.9937,1722.2386,1710.5938,1700.5891,1686.4421,1659.6783,1665.9034,1642.3805,1652.6572,1688.4575,1688.2246,1740.3029,1788.6471,1851.3091,1876.3774,1845.5946,1803.2158,1790.9224,1761.5616,1697.6996,1681.0533
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('00','00','20140126',
1729.3997,1755.5341,1766.6057,1708.2153,1723.2379,1682.0532,1660.9047,1671.8452,1687.74,1703.2891,1675.97,1653.5011,1613.4373,1621.1724,1624.8854,1616.267,1638.5576,1657.0479,1633.248,1639.2931,1683.1018,1743.8466,1798.8033,1824.2617,1853.2772,1880.9059,1859.5476,1857.7682,1931.859,1988.3462,2043.4419,2068.813,2079.9067,2077.7903,2072.1309,2075.7156,2090.4182,2113.6111,2109.8303,2154.1575,2150.5671,2142.8606,2100.3149,1981.2616,1896.8667,1835.1246,1847.6874,1858.719,1962.8296,1970.4061,2039.302,2024.0021,2037.3381,2012.3704,1992.9675,2017.6697,1944.7852,1956.2163,1961.0414,1950.2056,1932.5199,1959.2207,1973.4626,1956.3282,1961.2837,1948.4591,1907.6287,1847.2915,1803.4065,1765.5012,1738.324,1746.2634,1730.9728,1717.5443,1726.9362,1719.3848,1717.2361,1718.0515,1675.1926,1664.5286,1635.745,1666.3154,1648.5609,1637.0741,1672.6815,1687.9749,1703.6556,1744.9354,1866.3198,1864.3301,1850.0254,1811.5642,1798.3278,1751.5472,1738.7252,1723.0271
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('00','00','20140125',
1740.6346,1735.5002,1740.265,1719.2737,1723.5952,1685.6702,1700.4517,1679.0701,1679.1057,1674.3052,1656.4865,1675.3303,1643.3285,1649.9523,1649.4125,1604.1209,1613.6553,1647.844,1633.2891,1651.3196,1685.5706,1703.0142,1791.6256,1841.4152,1825.6055,1902.3447,1864.4362,1890.0482,1922.3834,2005.15,2026.8259,2049.0002,2059.9158,2083.5728,2111.1143,2101.8762,2095.3843,2089.8115,2135.9404,2125.1975,2171.6428,2158.3442,2143.2356,2019.4624,1916.5975,1830.2239,1809.9572,1856.0059,1965.9285,2001.2299,2052.428,2070.78,2046.0944,1993.2656,2016.1002,2025.9763,2030.3683,1964.6929,1975.2084,1980.7441,1958.1332,1965.0093,1975.9475,1963.8054,1976.2419,1961.9926,1942.1852,1862.9208,1800.1108,1771.5817,1739.4657,1727.123,1732.8621,1727.1704,1749.142,1764.3137,1738.3185,1755.4706,1739.328,1704.3794,1710.1515,1672.267,1657.1768,1677.8726,1741.4209,1740.0602,1765.7955,1830.6908,1898.1462,1906.5963,1890.8781,1854.9775,1828.6571,1803.984,1746.3109,1703.6111
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('00','00','20140124',
1721.1399,1715.4596,1725.1273,1707.2596,1689.6885,1673.6442,1672.8728,1682.2935,1643.3137,1646.2417,1652.2667,1643.8967,1643.3916,1605.1001,1623.5055,1637.5204,1626.3375,1623.1061,1656.597,1664.9188,1690.6573,1712.9769,1771.7504,1798.9939,1845.6831,1864.1578,1852.423,1897.7772,1929.2028,1995.6063,2053.123,2050.9751,2071.8323,2074.5479,2062.3711,2064.7888,2063.2644,2085.001,2111.6804,2131.4778,2157.0874,2147.6479,2116.6985,2013.6965,1928.371,1795.141,1832.0243,1878.3273,1958.3969,2025.2159,2045.8466,2040.7119,2015.941,2006.3506,2004.8456,2005.6548,1974.5584,1973.6533,1969.2944,1963.2572,1959.1171,1956.9342,1966.766,1959.1621,1971.413,1966.1356,1939.8878,1876.6526,1793.488,1783.4685,1749.6428,1760.3092,1746.1031,1752.3578,1760.614,1766.4443,1771.4836,1777.8527,1785.1946,1748.7454,1747.7175,1731.4823,1706.8396,1718.8506,1723.7911,1726.3075,1793.9598,1840.2806,1914.869,1928.5125,1917.5276,1900.9318,1847.4172,1795.1569,1795.7582,1776.7413
);
--插入电网00历史负荷结束

--插入电网03历史负荷
--INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
--T0015,T0030,T0045,T0100,T0115,T0130,T0145,
--T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
--T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
--T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
--T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
--T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
--T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
--T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
--T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
--T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
--T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
--T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
--T2400) VALUES ('03','00','20140130',
--569.2227,564.4376,563.8047,559.582,558.7415,560.7606,555.2817,557.0659,556.1994,557.5571,547.1605,543.5941,542.008,539.793,538.975,539.0314,538.1981,539.6559,536.6499,533.7503,538.8531,545.6835,551.9191,552.127,563.1931,566.8835,569.1695,573.9471,580.8937,587.8376,593.7968,592.1313,588.6537,594.6451,585.7954,595.3121,590.0024,594.3668,603.4745,604.8107,609.5366,607.5662,603.0715,585.4597,572.0095,569.7292,569.1818,580.9579,585.0884,589.4587,593.6078,588.4045,584.4745,586.3931,585.309,581.1192,579.5011,571.4406,571.816,572.2169,569.2873,564.9988,570.3205,573.4736,577.3892,575.3196,570.0012,564.5181,544.9729,540.8137,538.766,534.5422,530.1781,526.1732,528.0433,526.2248,514.4595,516.4552,514.6869,517.3995,512.7167,510.4161,510.1682,510.534,533.5435,534.8566,535.66,547.4014,561.8762,560.1219,555.7688,553.0048,548.8536,544.8991,540.9196,538.0872
--);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000) VALUES ('03','00','20140130',
569.2227,564.4376,563.8047,559.582,558.7415,560.7606,555.2817,
557.0659,556.1994,557.5571,547.1605,543.5941,542.008,539.793,538.975,
539.0314,538.1981,539.6559,536.6499,533.7503,538.8531,545.6835,551.9191,
552.127,563.1931,566.8835,569.1695,573.9471,580.8937,587.8376,593.7968,
592.1313,588.6537,594.6451,585.7954,595.3121,590.0024,594.3668,603.4745,
604.8107
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('03','00','20140129',
566.0739,561.8814,563.7449,560.7415,560.6402,557.9543,560.8019,557.2927,556.3184,548.9873,548.2406,548.3045,547.3877,545.3411,548.5465,548.9764,543.3768,539.1366,539.7163,546.6468,555.946,558.3268,568.1048,574.0453,579.9598,581.8534,585.1537,577.6026,593.8536,594.1047,608.8981,609.1131,601.937,627.3567,650.8355,649.7425,657.048,638.5492,646.0622,640.3731,648.4059,646.6187,633.0447,610.7944,597.6425,598.4996,596.6326,601.1848,607.1316,612.0853,616.53,616.8972,604.6901,604.196,602.7585,600.3497,592.303,593.8068,593.9134,590.1688,593.2281,589.4618,594.1384,594.6548,593.8426,596.2542,591.131,581.7842,569.7939,573.4464,567.0946,555.9167,555.2374,555.9222,555.703,547.6575,537.9582,537.3588,537.3106,534.1729,531.8707,530.1132,531.0593,534.8232,548.4637,552.5889,545.387,556.6092,576.1889,575.6117,575.8254,567.4536,562.3033,562.6179,560.2294,558.8903
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('03','00','20140128',
540.1097,533.3524,537.6194,532.897,530.654,531.6301,528.2717,522.5565,521.8226,519.4857,522.8279,521.259,520.1141,519.7005,522.4301,520.269,519.2928,514.6233,516.314,513.7829,528.2367,539.6717,548.1065,551.0218,554.4299,559.4786,557.6718,563.1727,569.861,574.2285,580.2945,572.1541,562.1503,559.3344,566.6627,571.4677,572.106,566.5154,564.8713,572.6055,577.2755,571.9835,562.058,543.9656,528.2037,527.6113,529.2322,531.894,538.9642,542.7794,550.5394,552.9848,543.9894,538.8546,541.6571,543.7541,551.8274,547.1107,544.1888,549.315,546.8673,553.3121,550.5404,552.7316,558.0576,559.4426,558.152,548.0535,548.9125,539.3807,530.6879,521.7777,522.3403,524.8406,525.6012,519.6989,517.8008,513.8222,510.0676,516.4949,517.7975,515.3598,512.3277,523.4467,541.0688,547.153,554.4614,567.6429,583.583,584.0327,581.7477,575.2281,565.5814,568.4852,568.3973,567.1027
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('03','00','20140127',
530.2498,530.8917,533.2052,531.1523,527.035,529.1887,527.8707,526.2158,525.799,525.0109,520.642,517.1476,521.0496,520.3321,519.4578,521.7208,518.9511,515.7511,520.1319,520.3805,527.6383,533.2471,544.2614,545.5732,545.4919,546.3978,551.395,550.0265,560.0278,560.6695,557.9675,555.9503,549.5319,553.1443,550.1165,549.0059,553.7865,558.87,563.376,572.5151,574.3102,569.9391,568.9755,551.7615,538.9981,540.0183,543.9916,545.5489,549.3373,554.6219,561.6172,561.2269,557.2136,558.4158,553.6686,562.5486,560.7656,559.505,560.093,562.3979,562.1519,560.5248,558.691,553.6541,554.8245,553.9989,553.8784,545.3047,539.9915,537.6423,535.5984,527.3875,522.0606,526.2026,526.4378,510.6546,509.2334,508.4905,508.525,506.3121,503.5233,501.8,498.3792,509.6837,529.265,532.8992,529.6103,540.554,546.653,551.433,549.1355,547.6233,543.2771,548.0068,541.9464,539.6144
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('03','00','20140126',
567.8526,560.3996,570.3212,560.6661,558.4653,560.3718,557.5563,554.1377,553.9199,553.4843,548.1659,545.8361,543.4095,543.7622,542.697,539.7516,541.107,540.6776,534.3799,539.9902,547.4706,549.7456,560.3023,561.0385,565.172,569.881,568.3268,577.7747,578.8295,583.9943,587.383,579.152,578.2463,578.089,582.2811,587.2221,591.5709,594.9841,600.3024,604.6469,609.2384,603.8452,588.0523,573.2104,562.8069,558.2102,558.1979,558.522,566.1368,560.5614,568.0272,572.0858,564.4955,561.5037,567.8178,563.4608,558.251,559.6215,557.6399,563.8809,561.1575,560.0763,563.5547,566.9558,558.1116,562.5684,562.5131,553.0821,539.3848,523.8574,519.0707,519.1,514.3732,514.1608,509.7635,500.1556,497.211,495.5995,494.8274,493.2991,486.3647,484.5327,485.4701,488.6801,511.5994,515.9211,515.4468,524.5081,550.2699,549.9358,549.2026,539.948,537.6877,536.0284,539.0512,537.041
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('03','00','20140125',
555.4276,552.0308,554.3247,552.3669,548.8647,545.2894,541.4764,543.7592,542.7863,539.4068,536.1808,532.8736,529.844,531.92,534.0253,528.5568,525.8944,527.8936,527.647,533.0897,538.4977,547.1018,557.7203,563.8212,571.6688,574.6411,577.5729,575.383,583.9756,592.7563,600.2197,595.6699,590.7712,590.413,588.9681,590.1616,590.3371,593.3641,591.9219,589.2615,595.6933,595.5695,584.7063,567.633,552.0786,551.1238,551.7999,557.6254,565.7938,569.4292,586.4498,591.2614,575.5692,576.1291,578.3612,579.0404,580.1176,569.7852,569.8619,576.6024,573.5525,569.8989,576.1265,580.1726,582.5059,582.2967,578.9104,570.3109,559.8492,555.7511,549.3669,541.5066,535.5033,541.8619,531.774,527.5095,527.5553,526.1191,522.5889,518.9794,518.2618,514.0183,512.2164,518.8613,545.8519,540.7076,539.5013,554.5272,571.614,571.905,570.4193,566.8837,567.8593,568.1891,567.6229,558.645
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('03','00','20140124',
574.0858,576.64,574.0709,574.6029,569.105,568.8474,574.4324,566.9767,564.4901,565.1596,561.4817,560.3636,560.9199,558.6136,560.8857,552.6971,547.5275,550.2033,549.3088,551.7349,558.5191,561.8801,576.4313,577.8778,579.4476,585.0334,584.5627,587.059,589.5163,597.9738,604.3681,586.921,583.3042,587.225,581.6437,590.3823,584.3857,585.4282,590.7616,593.5409,598.3135,597.0229,584.8195,567.6089,555.2504,550.0908,551.9761,558.5159,562.7592,567.1476,574.9067,572.1338,567.2108,564.2051,570.2497,570.0201,571.5885,567.6953,567.9036,577.2204,574.9413,574.6536,578.3335,579.7092,585.8574,588.2054,581.0564,570.3569,553.9633,554.4994,553.8472,555.7323,545.7897,541.9194,529.3944,524.9753,523.7964,531.6034,537.2189,534.0032,530.5587,530.8087,527.7378,526.7972,537.6199,536.8416,536.6592,551.0177,572.3611,573.9033,572.7206,567.5294,566.1141,564.9946,561.0167,558.4343
);
--插入电网03历史负荷结束

--插入电网04历史负荷
--INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
--T0015,T0030,T0045,T0100,T0115,T0130,T0145,
--T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
--T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
--T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
--T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
--T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
--T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
--T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
--T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
--T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
--T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
--T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
--T2400) VALUES ('04','00','20140130',
--338.0313,328.7919,339.9769,334.2715,332.5918,334.387,331.2956,331.003,325.847,330.0074,323.7898,324.4309,316.9612,313.8237,311.2064,302.2829,293.6876,296.6652,301.7105,296.7848,286.9291,297.0263,288.4558,311.4111,300.4876,298.3549,311.5574,320.8393,325.465,338.3192,341.532,336.4899,338.112,337.7328,325.6295,334.0565,329.0898,322.3687,326.7343,328.9665,331.7556,330.9678,339.3632,319.0053,310.069,297.113,299.7688,305.2218,307.7659,325.5711,342.7334,326.5729,325.4678,322.1788,329.2366,310.0432,305.2823,292.0734,282.9716,283.6741,287.6676,275.7529,273.2475,278.2613,282.5865,282.5558,283.6625,269.8786,261.0829,253.4429,247.8294,242.1436,242.2537,242.2957,240.0911,243.0831,237.4802,243.4398,236.7324,238.1302,235.0437,235.009,232.4431,241.6181,239.944,254.6627,264.496,304.6161,326.9128,325.8792,323.1304,318.548,317.1638,314.4731,309.4167,311.0168
--);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000) VALUES ('04','00','20140130',
338.0313,328.7919,339.9769,334.2715,332.5918,334.387,331.2956,
331.003,325.847,330.0074,323.7898,324.4309,316.9612,313.8237,311.2064,
302.2829,293.6876,296.6652,301.7105,296.7848,286.9291,297.0263,288.4558,
311.4111,300.4876,298.3549,311.5574,320.8393,325.465,338.3192,341.532,
336.4899,338.112,337.7328,325.6295,334.0565,329.0898,322.3687,326.7343,
328.9665
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('04','00','20140129',
351.3533,349.7496,350.3554,345.2665,354.4823,347.235,349.3866,337.875,326.0336,330.4137,331.4601,330.9707,318.4275,319.3001,307.3022,311.7487,321.3431,319.7003,310.191,310.7347,305.6915,324.8748,335.0405,335.7159,334.9362,325.335,347.8192,344.545,362.3108,369.3593,383.9719,380.8728,395.0094,385.5054,385.8927,391.1703,379.5314,379.5136,384.8149,389.2541,390.2606,381.7581,405.1468,384.2675,366.8449,349.3116,353.0932,353.2938,367.705,380.7286,399.3685,403.5143,398.3044,383.1363,390.8379,378.1871,379.2678,372.9091,371.0148,337.7359,346.1419,347.4401,351.979,343.4146,342.1241,338.0723,333.2057,315.8283,302.9976,300.6389,296.7008,296.608,289.407,299.3141,300.4782,300.0115,286.4416,283.8907,281.4209,274.7835,273.1258,276.0463,270.8511,279.656,286.967,304.8145,333.4879,353.2237,372.8394,372.382,365.1947,358.0432,363.5612,354.3827,347.2404,346.4179
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('04','00','20140128',
361.0082,353.9052,358.5448,351.6993,354.4055,347.6695,349.2244,347.8871,348.0253,330.2994,338.1794,343.3969,333.9386,333.4043,322.4879,327.0668,318.7015,315.5082,316.4027,325.4639,329.4842,334.6134,342.0173,336.5039,347.9539,350.8727,359.1886,332.9394,363.9082,369.0233,384.7176,384.1696,376.6349,390.6045,376.9101,396.9048,376.8115,381.5421,394.1221,395.1585,394.495,390.4807,383.8407,365.7263,369.2606,363.872,360.9455,368.5382,377.1013,389.8276,401.8009,398.7574,395.9722,399.1495,393.5868,396.0097,382.9149,379.2072,377.8647,359.4938,357.0938,360.2654,356.786,356.1305,358.2002,354.3832,347.4802,328.5119,309.7914,304.3455,309.5065,303.7862,298.8956,297.2043,300.961,286.5826,282.5408,280.6356,278.5044,277.0416,281.0262,278.0301,276.3146,284.8792,293.3198,309.3162,343.2416,357.7021,379.1728,381.8151,379.1104,368.8422,364.4061,364.1178,375.012,365.8123
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('04','00','20140127',
376.8867,370.7548,358.0519,364.9796,366.3297,354.335,348.7046,350.7168,343.1321,344.611,338.9979,344.1339,321.8745,332.6459,332.2838,332.9821,324.117,314.1228,319.2014,328.1292,334.4504,342.4402,343.9751,339.9671,342.0735,347.4207,355.6929,352.7111,371.693,383.0551,391.0746,389.2705,406.1021,407.1641,416.2679,415.0124,409.6238,396.7147,400.1309,402.4218,405.6948,398.3694,408.1423,385.3717,370.4346,347.6503,348.0114,344.9835,372.9243,389.3373,405.5986,397.7943,396.707,398.582,396.9874,390.4102,376.0527,367.2307,363.6371,348.2691,349.4696,359.2832,350.5299,346.2222,352.978,355.7254,346.305,322.3407,304.0427,300.4781,299.619,301.7259,298.6705,297.6851,298.0027,280.045,281.4323,280.8096,276.8167,272.2184,266.9708,269.1659,270.1144,269.5838,289.4361,309.2292,344.514,360.6822,381.3776,381.6704,377.2938,374.0153,376.6963,375.8226,372.0231,354.9546
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('04','00','20140126',
361.2859,359.267,363.3344,355.8007,362.6365,351.3637,352.0001,352.4658,339.9474,343.5796,338.9445,338.0916,332.1457,329.7512,331.4005,314.3842,325.8628,328.0275,315.8424,316.2514,321.1599,322.8115,335.5337,341.809,349.2248,354.9914,360.98,360.0281,370.7882,365.267,392.1005,402.3234,405.8862,410.9386,404.3459,404.0953,398.2628,400.7144,400.6385,408.3537,402.911,402.4232,408.6248,389.7924,371.2256,355.8365,361.7991,365.3969,388.5161,392.5059,404.4892,406.452,401.0989,397.6704,376.0914,383.6227,353.2014,351.9124,351.3378,347.157,342.2481,347.2317,345.6659,346.3151,349.5946,344.3298,338.572,331.8876,313.3485,304.7326,304.7307,307.4081,304.0044,307.691,293.14,293.2716,293.3925,292.9162,285.4585,282.953,278.6672,282.4231,278.8666,277.8551,291.4217,309.8853,347.8316,358.4368,385.1637,382.5407,385.2978,384.4421,386.7834,377.1942,377.4065,375.3227
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('04','00','20140125',
367.9196,368.9369,365.3899,345.1005,361.4796,361.3298,356.2688,361.7857,363.6984,354.9861,356.9086,348.8719,341.1302,333.5931,342.3333,327.0678,333.5013,338.1756,333.9902,335.3579,331.9014,334.6906,337.1559,343.8014,327.4128,353.4805,349.2055,359.8324,378.7423,387.5625,394.3721,404.8105,408.4532,417.455,402.1927,397.2434,389.6752,383.9889,399.0209,400.1489,400.0889,392.634,412.4624,385.3471,376.1636,352.7852,341.4689,360.6632,381.5831,394.4626,392.4736,396.9049,394.9464,387.1356,392.9963,378.046,381.2434,353.9069,354.5029,358.8609,350.6553,349.5725,350.2415,349.4567,342.7896,347.0538,345.0645,326.7805,308.2049,307.6311,304.1198,297.4079,298.9133,297.0766,303.516,303.874,304.293,307.3044,300.4035,292.3172,286.2784,283.4594,284.4833,288.5842,304.7386,316.0422,345.7831,365.5196,391.6177,395.5593,388.3653,383.6313,381.7857,379.8683,372.1974,354.417
);

INSERT INTO LF_HIS_96LC (NETID,CALIBERID,YMD,
T0015,T0030,T0045,T0100,T0115,T0130,T0145,
T0200,T0215,T0230,T0245,T0300,T0315,T0330,T0345,
T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,
T0600,T0615,T0630,T0645,T0700,T0715,T0730,T0745,
T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,
T1000,T1015,T1030,T1045,T1100,T1115,T1130,T1145,
T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,
T1400,T1415,T1430,T1445,T1500,T1515,T1530,T1545,
T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,
T1800,T1815,T1830,T1845,T1900,T1915,T1930,T1945,
T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,
T2200,T2215,T2230,T2245,T2300,T2315,T2330,T2345,
T2400) VALUES ('04','00','20140124',
373.606,370.5835,380.6753,366.034,373.9539,350.0757,362.5046,368.2007,349.2427,345.7769,349.5427,357.6956,345.1196,324.2629,336.2602,336.4164,336.9711,335.6546,345.2336,338.4814,341.2523,330.4213,351.8091,355.3246,359.7693,365.7723,358.4138,367.26,364.4778,380.8438,399.8697,406.3102,412.3002,417.4523,389.9939,397.5829,396.4681,399.7433,401.0222,403.512,399.2153,396.4902,412.8965,396.6695,385.1443,365.5652,352.5189,372.1713,394.1573,410.6561,403.8268,401.2202,389.4946,387.1482,381.3279,378.1997,354.4512,361.232,357.9927,346.1086,343.8608,342.4859,347.4034,343.7616,348.971,343.5853,340.5934,317.682,301.5494,297.7959,291.3039,298.1506,296.3621,300.8565,302.9243,304.958,299.9021,302.921,296.9896,295.7079,293.4906,291.2263,288.3891,290.945,296.5719,315.3171,360.935,370.1277,396.6116,399.3919,399.822,390.4088,391.2907,386.9193,380.0677,376.5545
);
--插入电网04历史负荷结束