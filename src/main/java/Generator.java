import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成
 *
 * @author ShenHuaJie
 */
public class Generator {
  /**
   * 生成代码
   */
  public static void main(String[] args) {
    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    // todo 生成路径
//    gc.setOutputDir("C:\\DMall_WorkSpace\\git_work\\dmall-purchase\\dmall-purchase-dao\\src\\main" +
//        "\\java\\");
    gc.setOutputDir("C:\\DMall_WorkSpace\\code\\test\\");
    gc.setFileOverride(false);
    gc.setActiveRecord(false);
    // XML 二级缓存
    gc.setEnableCache(false);
    // XML ResultMap
    gc.setBaseResultMap(true);
    // XML columList
    gc.setBaseColumnList(false);
    gc.setOpen(false);
    gc.setAuthor("soddygo");
    // 自定义文件命名，注意 %s 会自动填充表实体属性！
    gc.setMapperName("%sDao");
    gc.setServiceImplName("%sService");
    mpg.setGlobalConfig(gc);
    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setDriverName("com.mysql.jdbc.Driver");
    dsc.setUsername("soddygo");
    dsc.setPassword("631108");
    dsc.setUrl("jdbc:mysql://localhost:3306/dmall_purchase?characterEncoding=utf8&useSSL=false");
    mpg.setDataSource(dsc);
    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    // 表名生成策略
    strategy.setNaming(NamingStrategy.underline_to_camel);
    // 需要生成的表
    // 自定义 mapper 父类
    strategy.setSuperMapperClass("com.dmall.datalite.rdb.dao.DbBaseDao");
    // 自定义 service 父类
    strategy.setSuperServiceClass("com.dmall.datalite.rdb.service.DbBaseService");
    // todo 需要生成的表
    strategy.setInclude(new String[]{"purchase_supply", "purchase_supply_goods","purchase_history_price","purchase_excel_supply_history",
        "purchase_excel_goods_history","purchase_order","purchase_order_cancel","purchase_order_main"});
    // 此处可以修改为你的表前缀
    // todo 生成的实体不带表前缀
    strategy.setTablePrefix(new String[]{""});
    // 自定义 controller 父类
    mpg.setStrategy(strategy);
    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent("com.dmall.purchase");
    pc.setEntity("pojo");
    pc.setMapper("dao");
    pc.setXml("mapper");
    pc.setService("service");
    pc.setController("web.controller");
    mpg.setPackageInfo(pc);
    // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        // todo 实体的驼峰命名
        map.put("capitalName", "clientInfo");
        this.setMap(map);
      }
    };
    mpg.setCfg(cfg);
    TemplateConfig tc = new TemplateConfig();
    tc.setEntity("vm/dms.entity.java.vm");
    tc.setMapper("vm/dms.mapper.java.vm");
    tc.setXml("vm/dms.mapper.xml.vm");
    tc.setServiceImpl("vm/dms.serviceImpl.java.vm");
    tc.setController("vm/dms.controller.java.vm");
    mpg.setTemplate(tc);
    // 执行生成
    mpg.execute();
  }
}
