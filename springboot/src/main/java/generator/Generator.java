package generator;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：Generator
 * @Author：kuangzy
 * @Time：2019/5/5 17:12
 * @Discription:discription
 */
    public class Generator {
    //    方法1：
    //    在此路径下运行以下命令行，可以直接生成相关的实体类和mapper接口类、xml映射文件
    //    java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite

    //    方法2：
    //    使用这种方法首先需要引入generator的依赖
    //    注意修改xml文件的读取路径，默认是读取src的同级目录
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src//main//java//generator//generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

}
