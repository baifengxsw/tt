package cn.itcast.erp.biz;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cn.itcast.erp.entity.Supplier;
/**
 * 供应商业务逻辑层接口
 * @author Administrator
 *
 */
public interface ISupplierBiz extends IBaseBiz<Supplier>{
		/**
		 * 导出到excel文件
		 * @param os 输出流
		 * @param t1 查询条件
		 */
		public void export(OutputStream os ,Supplier t1);
		
		public void doImport(InputStream io ) throws IOException;
}

