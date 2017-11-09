package testRun;


import model.Human;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HumanService;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/context.xml");
        HumanService humanService = (HumanService) applicationContext.getBean("HumanService");
        humanService.create(getHuman1(1));
        humanService.create(getHuman1(3));

        logger.info("GetAllObjects:");
        for (Human human : humanService.getAllObjects()){
            logger.info(human.toString());
            System.out.println(human.toString());
        }
    }

    private static Human getHuman1(int number){

        Human human = new Human();
        human.setFirstName("sdf"+number);
        human.setLastName("dsfsdgsdg");
        human.setAge(number);

        return human;
    }
}
