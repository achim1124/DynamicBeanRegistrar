[Spring] 스프링 빈(Bean)이 초기화, 소멸 시 특정 작업을 하는 방법
 1. Spring에서 제공하는 InitializingBean, DisposableBean 인터페이스를 구현한다.
 2. 스프링 XML 설정
     <bean id="bookRegisterService" class="com.brms.book.service.BookRegisterService"
     init-method="initMethod" destroy-method="destroyMethod"/>
 3. xml 설정
    1. default-init-method와 default-destroy-method
 4. @Bean(initMethod=메소드명, destroyMethod=메소드명)
 5. BeanPostProcessor 설정
 





