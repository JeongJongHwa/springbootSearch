package kr.co.searchManager.database.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(value = "kr.co.searchManager.database.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DatabaseConfig {
	
	private static final Logger logger = LogManager.getLogger(DatabaseConfig.class);

	@Bean(name = "DataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.db.datasource")
	public DataSource db1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "SqlSessionFactory")
	@Primary
	public SqlSessionFactory SqlSessionFactory(@Qualifier("DataSource") DataSource DataSource,
			ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(DataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/search/*.xml"));
		return sqlSessionFactoryBean.getObject();

	}
	
	@Bean(name = "SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate SqlSessionTemplate(SqlSessionFactory SqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(SqlSessionFactory);
	}
	
//	public PlatformTransactionManager txManager() throws Exception {
//		return new DataSourceTransactionManager(db1DataSource());
//	}
}
