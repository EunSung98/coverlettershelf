# 눈물의 자소서
---
## 소개
- 과제로 만든 자기소개서 정리 사이트
- 잡000 사이트에서 자소서 저장해놓으려고 했으나 10개 이하만 저장할 수 있어 한정적
- 구글 드라이브에 자소서를 모아놔도 형식이 일정하지 않고 불편

## 사용 기술
- Backend : Spring (Java 1.8), Jsp
- Fronted : Boostrap (html, css, js)
- DB : MySQL, HeidiSQL
- apache tomcat 8.5

## 개발 기간 
- 2023.11 ~ 2023.12.13 (약 1달)

## 기능
1) 로그인,로그아웃 & 회원가입
- Cookie 아이디 저장
- Session에 로그인 아이디 저장
2) 내 자소서
- 내 자소서 등록, 전체 보기 & 상세 보기, 수정, 삭제, 검색 기능 (CRUDS, trigger) 
3) 공개 자소서
- 공개된 자소서 전체 보기 & 상세 보기
4) 회원정보
- 내 정보 보기, 수정
- 계정 탈퇴 : 10일 이내에 로그인하면 탈퇴 취소 (procedure 프로시저)

## 역할
기획, DB, 웹사이트 (1인 제작)
- login후 id는 session에 저장
- cookie로 아이디 저장 기능
- 자기소개서 게시판 기능 (CRUDS)
- trigger을 이용해 자기소개서 data 관리 (questions table의 fk키가 없어지면 row 삭제)
- 계정 탈퇴 실수를 방지 -> procedure로 10일내에 로그인 시 탈퇴 취소 
---
## [ 사이트 구조 ]
< Controller >
1. LoginServiceController.java
2. AccountController.java
![controller1](https://github.com/EunSung98/coverlettershelf/assets/77737044/dfc61556-3091-4368-a98e-b2e75e3b4317)

3. BoardController
![controller2](https://github.com/EunSung98/coverlettershelf/assets/77737044/60441e87-06bd-417f-8fe1-07376b205c7e)
---
## coverletter DB의 ERD
![coverletter_erd](https://github.com/EunSung98/coverlettershelf/assets/77737044/7d724936-f1ac-4833-b423-ae5ce2e178a3)

- 회원 아이디를 board 테이블의 FK로 지정 (update 시 : cascade, delete시 : set NULL)

[ trigger ]
- 외래키가 삭제될 때 해당 질문 row 삭제
```sql
CREATE TRIGGER delete_questions
BEFORE DELETE
ON board FOR EACH ROW
BEGIN
    DELETE FROM questions WHERE board_id = OLD.board_id;
END;
```

[ procedure ]
- procedure10일 내에 로그인시 계정 탈퇴 취소되는
```sql
BEGIN
    UPDATE users
    SET deleteDate = NULL
    WHERE lastLogin <= DATE_SUB(deleteDate, INTERVAL 10 DAY) AND deleteDate IS NOT NULL;

    DELETE FROM users
    WHERE lastLogin > DATE_SUB(NOW(), INTERVAL 10 DAY) AND deleteDate IS NOT NULL;
END
```
---
## [ View jsp 파일 설명 ]

1. 공통 파일
- header.jsp : 로그인 유무에 따라 header가 변경
- footer.jsp : 웹 페이지 밑 부분
- error.jsp : error 발생시 이동
2. 첫화면, 로그인/회원가입 
- home.jsp : 간단한 소개, 로그인&회원가입 유도
- loginService/login.jsp : 로그인
- loginService/memberJoin.jsp : 회원가입
3. 자소서 페이지
- board/main.jsp
- board/myPage.jsp
- board/modifyPage.jsp
- board/upload.jsp
- board/total.jsp
- board/page.jsp
4. 회원 정보 
- account/account.jsp
- account/accountModify.jsp
---
### < 자기소개서 CRUD >
- 첫 번째 페이지에서 로그인 / 회원가입 선택
- 회원 가입 후, 로그인
- onsubmit을 이용해서 유효성 검사

회원가입 (firstStep/signUp.jsp)
![image](https://github.com/EunSung98/readMemo/assets/77737044/d3bbcfb4-fe73-45b7-8656-9b792c88b7f5)

로그인
(firstStep/login.jsp)
![image](https://github.com/EunSung98/readMemo/assets/77737044/58ac383b-b003-4423-94ec-b34762e10d78)


---
### < 자기소개서 검색 >
- 제목, 저자, 감상문을 입력해서 저장
- 감상문 등록 (memo/upload.jsp)
- 감상문 전체 보기 (memo/diary.jsp)

![image](https://github.com/EunSung98/readMemo/assets/77737044/3233edc3-8cf4-4060-88fc-44fc1ba931f4)

---
### < 공개 자기소개서 보기 >

- 제목, 저자, 감상문을 수정해서 저장
- 감상문 수정(memo/modify.jsp)

![image](https://github.com/EunSung98/readMemo/assets/77737044/de6498a7-ae43-413e-b832-a823fc18d237)


---
### < 계정 탈퇴 >

- 삭제 버튼으로 삭제하기

![image](https://github.com/EunSung98/readMemo/assets/77737044/9d561d6a-33fb-4a8e-a30a-5f435a7ca62b)


---
### < 감상문 로그아웃, 아이디 저장 >

- 로그아웃 버튼으로 session에 있는 id 값 삭제
- 로그인 페이지의 아이디 저장으로 쿠키에 남은 id 값

![image](https://github.com/EunSung98/readMemo/assets/77737044/58f1976f-4761-4894-af66-223f10c2e4a8)

