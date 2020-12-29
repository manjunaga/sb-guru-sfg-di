package guru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.GetterInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import guru.springframework.sfgdi.examplebeans.FakeJMSBroker;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
		System.out.println("==============================================================");
		FakeDataSource fakedataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		System.out.println("FakeDataSource Username " + fakedataSource.getUsername());
		System.out.println("FakeDataSource Password " + fakedataSource.getPassword());
		System.out.println("FakeDataSource Dburl " + fakedataSource.getDburl());
		System.out.println("==============================================================");
		FakeJMSBroker fakejmsbroker = (FakeJMSBroker) ctx.getBean(FakeJMSBroker.class);
		System.out.println("FakeJMSBroker Username " + fakejmsbroker.getUsername());
		System.out.println("FakeJMSBroker Password " + fakejmsbroker.getPassword());
		System.out.println("FakeJMSBroker Dburl " + fakejmsbroker.getDburl());
	}
}
