1. Bean 생성되면서 호출되는 순서를 알아 보자
2. ImportBeanDefinitionRegistrar.registerBeanDefinitions
   1. 다른 bean이 초기화(instance)화 전이기 때문에 다른 bean 사용 못함.
3. BeanFactoryPostProcessor.postProcessBeanFactory
   1. 상속 클래스 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry 도 해당 시점에 호출됨.
   2. 다른 bean이 초기화(instance)화 전이기 때문에 다른 bean 사용 못함.
4. bean instance(초기화)... (어디서 하는지 찾아 보자)
5. Dependence Injection 의존성 주입... (어디서 하는지 찾아 보자)
6. 
7. BeanPostProcessor 가 호출되는 시점에는 모든 bean이 초기화(instance) 된 상태이므로 applicationContext에서 자유롭게 bean을 꺼내 쓸수 있다.
8. BeanPostProcessor.postProcessBeforeInitialization
9. @PostConstruct
10. BeanPostProcessor.postProcessAfterInitialization
11. ApplicationContextAware.setApplicationContext

BeanPostProcessor에서 Bean을 등록하면
장점 : ConfigurationProperties나 다른 Bean들을 사용할 수 있음
단점 : Bean 생성 시점이 늦어져서 @Configuration 내에서 참조가 되지 않을 수 있음

BeanFactoryPostProcessor에서 Bean을 등록하면
장점 : 다른 Bean의 의존성에 문제가 없음
단점 : ConfigurationProperties를 가져오지 못해 별도로 설정을 읽는 처리를 해야 함
