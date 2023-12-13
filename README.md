# 눈물의 자소서
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/2b582025-3090-4f8a-aca8-e2abf1539fa1" width="40%" height="40%"/>

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
    WHERE lastLogin >= DATE_SUB(deleteDate, INTERVAL 10 DAY) AND deleteDate IS NOT NULL;

    DELETE FROM users
    WHERE lastLogin < DATE_SUB(deleteDate, INTERVAL 10 DAY) AND deleteDate IS NOT NULL;
END
```
---
## [ View jsp 파일 설명 ]

1. 공통 파일
- header.jsp : 로그인 유무에 따라 header가 변경
- footer.jsp : 웹 페이지 밑 부분
- error.jsp : error 발생시 이동
2. 첫화면, 로그인/회원가입 
- home.jsp : 간단한 소개, 로그인&회원가입 유도 <br>
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/2b582025-3090-4f8a-aca8-e2abf1539fa1" width="40%" height="40%"/>  <br>
- loginService/login.jsp : 로그인  <br>
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/39d87818-edbc-4c11-ada6-2a79d7f01778](https://github.com/EunSung98/coverlettershelf/assets/77737044/698fee16-d8c3-415d-bb14-21d41184ee3a)" width="40%" height="40%"/>  <br>
- loginService/memberJoin.jsp : 회원가입  <br>
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/3cb82322-2d5d-4893-a02c-021c9755b158" width="40%" height="40%"/>  <br> 

3. 자소서 페이지
- board/main.jsp <br> 
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/1d80ab00-8b10-4067-ada3-4bcb02501bf2" width="40%" height="40%"/>  <br> 
- board/myPage.jsp <br> 
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/f8d68d2a-f96a-4385-b86b-6197e80a983f" width="40%" height="40%"/>  <br> 
- board/modifyPage.jsp <br>
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/3b70125f-441b-4cd6-b6f0-1bc5901ae500" width="40%" height="40%"/>  <br> 
- board/upload.jsp
- board/total.jsp  <br> 
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/29aafa55-ea6a-43e4-8c6f-0b0df33f6b99" width="40%" height="40%"/>  <br> 
- board/page.jsp
4. 회원 정보 
- account/account.jsp 
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/881dfd95-a257-4a86-ac32-117c258fcb73" width="40%" height="40%"/>  <br> 
- account/accountModify.jsp 
<img src="https://github.com/EunSung98/coverlettershelf/assets/77737044/c551f71e-30e9-4f75-8741-0f515421be70" width="40%" height="40%"/>  <br> 





