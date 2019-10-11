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
