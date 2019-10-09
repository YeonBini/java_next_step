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
