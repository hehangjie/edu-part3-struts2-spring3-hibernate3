package edu.common.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		/*
		 * org.hibernate.tool.hbm2ddl.SchemaExport工具类： 需要传入Configuration参数
		 * 此工具类可以将类导出生成数据库表
		 */
		SchemaExport export = new SchemaExport(cfg);
		/*
		 * 开始导出 第一个参数： script 是否打印DDL信息 第二个参数： export 是否导出到数据库中生成表
		 */
		export.create(true, true);
		
		System.out.println("Exprot Success");
	}
}
