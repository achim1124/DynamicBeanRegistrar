1. @Configuration(proxyBeanMethods = false) 찾아보기
   Spring FrameWork 5.2에 추가됐다
   Spring FrameWork 5.2 , Spring Boot 2.2 기준 AutoConfiguration Class에 주로 사용되고 많은 설정이 필요할 때 사용한다
   @Configuration 속성 proxyBeanMethods를 이용하면 구동 시간과 메모리 사용량을 줄일 수 있다.
   구동 시간, 메모리 사용량 줄일 수 있는 이유
   리플렉션을 하지 않고 프록시를 생성하지 않기 때문에 성능적인 이점이 있다.
   인스턴스를 호출시마다 생성하므로 싱글톤으로 생성하지 않아서 여러 번 호출한다
   @Configuration(proxyBeanMethod = false)이라고 해당 클래스의 @Bean 메서드를 호출할 때 메서드로 인식해서 등록
2. @Configuration(proxyBeanMethods = true) 찾아보기
   CGLIB Proxy를 사용한다.
   Bean 간의 참조를 허용한다.
3. 
   인스턴스 호출 시 메서드를 가로채서 한번 호출되고 싱글톤으로 인스턴스를 생성한다. 이것이 핵심이다.