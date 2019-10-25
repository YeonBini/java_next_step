# java_next_step
Practice for Next_Step book 

### Chapter 2. 
> 생각해볼거리 
1. 실제로 서비스를 담당하는 프로덕션 코드와 이 프로덕션 코드가 정상적으로 확인하기 위한 main() 혹은 테스트 코드로 분리
2. 프로덕션 코드에서 접근자(public, protected, private 등)을 설정하는 기준은 무엇? 
3. private method는 테스트를 해야하는가? 
4. 프로그래밍에서 else를 사용하지 말라고 한다. 왜? 
5. 요구사항 이외에도 추가적으로 필요한 요구사항에 대해서 계속 고민 필요. 추가적인 예외 상황이 있는지에 대한 검토 
기타. intellij에서 일반 java project junit 설정 방법은? (하긴 했지만 구리게 한 거 같음)


### Chapter 3. 
> 유용한 자료 및 링크들 
- 리눅스 커널 : [리눅스 커맨드라인 완벽 입문서] or <https://youtu.be/JbH-xzD7IkE>
- 크롬 개발자 도구 : <http://goo.gl/Mq6hRd> (링크 깨짐)

> Cookie 관련 내용
1. 서버에서 한 번만 쿠키 정보를 보내면 브라우져에서 쿠키를 유지함 
1. 쿠키 생성 케이스 
    - 처음 로그인 했을 때 최초에 logined=true 만들어줌 
    - 한 번만 logined=true만들어준 이후에는 따로 세팅해줄 필요 없음 
    - 로그아웃 했을 때 logined=false로 만들어 줌 
1. 쿠키 생성 시 /user 하위에서 쿠키를 생성하면 /index.html에서는 생성된 쿠키가 보이지 않는다. 
    - Set-Cookie에서 path를 지정해주어야 한다. (예 : Set-Cookie: logined=true;path=/)
    
### Chapter 5. 
> java 파일에서 파일 경로 설정 
- './'로 설정하면 프로그램의 root로 인식을 하는 건가?
    * 정적 콘텐츠(html, css, javascript)의 경우에는 리소스이기 때문에 .., ..., ../ 등으로 상대경로를 지정하지만, 동적 콘텐츠의 경우(class 파일) 프로젝트 폴더를 기준으로 경로가 설정이 된다. (예: ./로 하면 프로젝트 폴더의 1depth이다.)

> java i/o package 정리
- 자바에서 데이터는 스트림(Stream)을 통해 입출력 된다. 
- 바이트 기반 스트림은 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 받고 보낼 수 있으나, 문자 기반 스트림은 오로지 문자만 받고 보낼 수 있도록 특화되어 있다. 

|java.io 패키지의 주요 클래스|설명|
|:---|:---|
|File|파일 시스템의 정보를 얻기 위한 클래스|
|Console|콘솔로부터 문자를 입출력하기 위한 클래스|
|InputStream/OutputStream|바이트 단위 입출력을 위한 최상위 입출력 스트림|
|FileInputStream/FileOutputStream</br>DataInputStream/DataOutputStream</br>ObjectInputStream/ObjectOutputStream</br>PrintStream</br>BufferedInputStream/BufferedOutputStream|바이트 단위 입출력을 위한 하위 스트림
|Reader/Writer|문자 단위 입출력을 위한 최상위 스트림 클래스|
|FileReader/FileWriter</br>InputStreamReader/InputStreamWriter</br>PrintWriter</br>BufferedReader/BufferedWriter|문자 단위 입출력을 위한 하위 스트림 클래스|

> 생각할 거리들 
- 독립적으로 존재하는 상수 값은 굳이 enum으로 추가할 필요는 없지만, 남자(M), 여자(F) 또는 동,서,남,북 과 같이 상수값이 연관성을 가지는 경우 enum을 사용하기 적합하다. (예 :  GET, POST)
- 객체지향 설계를 처음 연습할 때 요구사항이 명확하지 않은 애플리케이션을 개발하기 보다 "지뢰찾기", "체스게임" 등 이미 요구사항이 명확한 애플리케이션으로 연습하는 것을 추천
- OCP(Open-Closed Principle) 원칙 : 요구사항의 변경이나 추가사항이 발생하더라도 기존 구성요소는 수정이 일어나지 말아야 하며, 기존 구성요소를 쉽게 확장해서 재사용할 수 있어야 한다.
- 서블릿은 앞에서 구현한 웹서버의 Controller, HttpRequest, HttpResponse를 추상화해 인터페이스로 정의해 놓은 표준. 서블릿은 웹서비스를 위한 인터페이스로, 원칙적으로는 javax.servlet.Servlet 인터페이스의 구현체. 일반적인 java 독립 실행프로그램과는 달리 main 메서드가 없으며, 서블릿 컨테이너에 등록된 후 컨테이너에 의해 생성, 호출, 소멸이 일어난다. 
서블릿 컨테이너는 이러한 서블릿을 관리하며 네트워크 통신, 서블릿의 생명주기 관리, 스레드 기반의 병렬처리를 대행한다. 즉, 웹 클라이언트로 부터 HTTP 요청이 전달되면 해당 HTTP 요청을 해석하여 적정한 서블릿의 service 메서드를 ServletRequet, ServletResponse 매개변수와 함께 호출.
- 서블릿 컨테이너는 요청이 들어올 때 마다 새로운 java thread를 만든다. 우리가 알고 있는 대표적인 서블릿 컨테이너가 Tomcat이다. Tomcat같은 was가 java 파일을 컴파일해서 class 파일을 만들고 메모리에 올려 서블릿 객체를 만든다.
- 컨테이너는 기본적으로 생명주기를 관리하는 기능을 제공한다. 컨테이너에 의해 인스턴스가 관리되기 때문에 초기화, 소멸과 같은 작업을 위한 메소드를 인터페이스 규약으로 만들어 놓고 확장할 수 있도록 지원하는 것이다.
- github의 특정 브랜치를 그대로 로컬에 생성하기

> 원격 저장소의 브랜치 로컬에 생성
~~~
git checkout -b step0-getting-started origin/step0-getting-started
~~~

### Chapter 6.
- UpdateUserServlet 에서 user정보 update 시 database를 호출하지 않아도 되는 것은 Database에서 addUser시 User 메모리 위치를 추가하기 때문에  해당 메모리 위치의 User 정보만 바꾸어주면 자동적으로 update가 된다.
- 세션이 상태 데이터를 웹 서버에서 관리한다는 점만 다를 뿐 HTTP에서 상태 값을 유지하기 위한 값을 전달할 때는 쿠키를 사용한다.
- @WebServlet에서 loadOnStartUp 조건 
    - 보통의 서블릿은 해당 서블릿에 최초 요청이 들어올 때에만 해당 인스턴스화 초기 설정을 하게 되는데, 이는 시간이 오래 걸리기 때문에 Context의 웹 애플리케이션이 톰캣에 의해 인식되는 시점에 서블릿이 초기화 되도록 설정하는 것 
    - 음수일 때는 톰캣 실행 시 자동으로 서블릿 호출되지 않으며, 양수일 때 0에 가까울수록 먼저 초기화됨. 같은 숫자가 mapping되었을 경우 먼저 작성된 서블릿부터 초기화됨
- [SerialVersionUID 생성 이유는?](http://woowabros.github.io/experience/2017/10/17/java-serialize.html) 
    - Serializable을 상속받은 객체이기 때문에(DispatcherServelt, Exception) 
    - 서블릿 기반의 WAS(톰캣, 웹로직 등)들은 대부분 세션의 자바 직렬화를 지원하고 있습니다.물론 단순히 세션을 서블릿 메모리 위에서 운용한다면 직렬화를 필요로 하지 않지만, 파일로 저장하거나 세션 클러스터링, DB를 저장하는 옵션 등을 선택하게 되면 세션 자체가 직렬화가 되어 저장되어 전달됩니다.
    - Exception 정의 시 SerialVersionUID가 중복되어도 괜찮은건가??
- tomcat에서는 localhost:8080경로로 들어왔을 때 기본적으로 index.jsp, index.html 파일을 먼저 찾는다. 
    - index.jsp 파일을  home.jsp파일로 변경하였음.
- dispatcherServlet에서  urlmapping을 "/" 로 해주는 것은 jsp 파일은 기본 톰캣 설정에서 찾게하며, 나머지 동적인 영역에 대해서 처리를 해주기 위함이다.
> shell script
```
    wget http://apache.mirror.cdnetworks.com/tomcat/tomcat-8/v8.5.47/bin/apache-tomcat-8.5.47.tar.gz
    gunzip apache-tomcat-8.5.47.tar.gz
    # -x : 압축해제, -v : 진행율, -f : 파일 
    tar -xvf apache-tomcat-8.5.47.tar
    ln -s apache-tomcat-8.5.47/ tomcat
    git checkout -b origin/step1-user-completed-no-database
    rm -rf /home/yeonbn/tomcat/webapps/ROOT
    cp -r jwp-basic /home/yeonbn/tomcat/webapps/ROOT
```
### Chapter7
- ContextLoaderListener 
    - 톰캣 서버가 시작할 때 contextInitialized() 메소드를 호출하여 초기화 작업 실행 
    - ContextLoaderListener는 ServeletContextListener 인터페이스를 구현하고 있으며 @WebListener 애노테이션이 설정되어 있다. 이 경우 서블릿 컨테이너를 시작하는 과정에서 contextInitialized() 메소드를 호출해 초기화 작업을 진행한다. 
    - 서블릿 초기화가 해당 서블릿과 관련한 초기화를 담당한다면 ServletContextListener 초기화는 웹 애플리케이션 전체에 영향을 미치는 초기화가 필요한 경우 활용할 수 있다.
- PreparedStatement에서 setValue 메소드 호출 시 리턴 값 없이 세팅만 해주어도 PreparedStatement에 반영이 왜 되는거지?
- PreparedStatementMapper, RowMapper 인터페이스 생성 
    - 메소드 하나만 가지는 인터페이스를 생성한 후 필요에 따라 메소드의 인자로 전달해 앞 단계에서 발생한 문제점을 해결했다. 즉, 변화 시점이 다른 부분을 서로 다른 인터페이스로 분리함으로써 공통 라이브러리에 대한 유연함을 높일 수 있게 되었다. 이 예제에서 사용한 인터페이스를 콜백(callback) 인터페이스라고 부른다. 
    - 콜백 인터페이스는 함수형 언어에서 함수를 메소드의 인자로 전달함으로써 유연함을 얻는 것과 같다. 자바가 인터페이스를 사용할 수밖에 없는 이유는 기본단위가 함수가 아닌 클래스이기 때문이다.
- Runtime Exception, Compile Exception 
    - [http://www.nextree.co.kr/p3239/](http://www.nextree.co.kr/p3239/)
- try-with-resource 구문에 사용할 클래스는  java.io.AutoClosable을 상속하고 있어야 한다.
    - Connection, PreparedStatement, ResultSet
- 제네릭을 사용하여 리팩토링 하면 데이터 조회 시 굳이 캐스팅을 하지 않아도 된다.
- 람다를 사용하려면 인터페이스의 메소드가 하나만 존재해야 한다. 또한 람다 표현식으로 사용할 인터페이스라고 지정하려면 인터페이스에 @FunctionalInterface 애노테이션을 추가해야한다.
- filter와 interceptor의 사용 사례
    - filter 
    - interceptor : 로깅 

### Chapter8

- model hashcode와 equals를 상속해야하는 이유에 대해서 
→[https://minwan1.github.io/2018/07/03/2018-07-03-equals,hashcode/](https://minwan1.github.io/2018/07/03/2018-07-03-equals,hashcode/)
- 자바스크립트의 this는 해당 함수를 누가 호출하느냐에 따라 this 가 변경된다....... 자바스크립트의 this에 대해 더 깊이 있게 학습하려면 자바스크립트 문서에서 Scope를 다루는 부분을 학습하면 된다. 이 부분을 학습하다보면 자바스크립트의 apply(), call(), bind() 함수도 등장하는데 이 세 함수의 차이점에 대해서도 학습해야 한다.
- ModelAndView를 만들어서 controller와 view에서 만들었던 model를 만들고, View는 주입을 받는다.
- db trigger로 답변 갯수를 기록할 수는 없을까?
