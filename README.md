# 눈물의 자소서
---
## 소개
- 과제로 만든 자기소개서 정리 사이트
- 잡000 사이트에서 자소서 저장해놓으려고 했으나 10개 이하만 저장할 수 있어 한정적
- 구글 드라이브에 자소서를 모아놔도 형식이 일정하지 않고 불편

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
요약 : 기획, DB, 웹사이트 (1인 제작)
- cookie로 아이디 저장 기능  →  로그아웃 후에도 아이디가 저장
- DB를 이용해 독서록을 보기/쓰기/수정/삭제
- 책 제목, 저자, 독서록 내용을 입력/수정  →  입력/수정한 날짜와 함께 저장되어 표시
- 로그인을 하면 id를 session에 저장  →   해당 id와 연결된 Table과 연동
- 로그아웃 -> session에 저장되어 있는 id를 삭제  →  첫번째 페이지로 이동
---
## [ 사이트 구조 ]
< Controller >
1. LoginServiceController.java
2. AccountController.java
![controller1](https://github.com/EunSung98/coverlettershelf/assets/77737044/dfc61556-3091-4368-a98e-b2e75e3b4317)

3. BoardController
![controller2](https://github.com/EunSung98/coverlettershelf/assets/77737044/60441e87-06bd-417f-8fe1-07376b205c7e)

![image](https://github.com/EunSung98/readMemo/assets/77737044/e71fe4f2-aa7e-41b0-b710-f777574d0d8c)

## coverletter DB의 ERD
![coverletter_erd](https://github.com/EunSung98/coverlettershelf/assets/77737044/7d724936-f1ac-4833-b423-ae5ce2e178a3)

- 회원 아이디를 books 테이블의 외래키로 지정해 연결

[ 10일 내에 로그인시 계정 탈퇴 취소되는 procedure ]
```sql
CREATE PROCEDURE deleteAccount()
BEGIN
  DECLARE currentDate TIMESTAMP;
  DECLARE tenDaysAgo TIMESTAMP;

  -- 현재 시간 
  SET currentDate = NOW();

  -- 10일 전 날짜 계산
  SET tenDaysAgo = DATE_SUB(currentDate, INTERVAL 10 DAY);

  -- 10일내 로그인 하는지 확인
  UPDATE users
  SET deleteDate = NULL
  WHERE lastLogin >= tenDaysAgo;

  -- 10일 이후인 회원 삭제
  DELETE FROM users
  WHERE deleteDate IS NOT NULL AND deleteDate < tenDaysAgo;

END 
```
---
## [ 사이트 파일 내용 ]

1. 공통으로 사용하는 파일
![image](https://github.com/EunSung98/readMemo/assets/77737044/6413171f-1c08-4b9b-8063-b4aaaf36e5a9)

2. 로그인/회원가입 페이지
![image](https://github.com/EunSung98/readMemo/assets/77737044/e470aec7-a1fa-4520-b48e-9764281566b6)

3. 메인 페이지
![image](https://github.com/EunSung98/readMemo/assets/77737044/5735c337-2275-4c4c-b515-9ab38b7df5d8)

---
### < 회원가입/로그인 페이지 >
- 첫 번째 페이지에서 로그인 / 회원가입 선택
- 회원 가입 후, 로그인
- onsubmit을 이용해서 유효성 검사

회원가입 (firstStep/signUp.jsp)
![image](https://github.com/EunSung98/readMemo/assets/77737044/d3bbcfb4-fe73-45b7-8656-9b792c88b7f5)

로그인
(firstStep/login.jsp)
![image](https://github.com/EunSung98/readMemo/assets/77737044/58ac383b-b003-4423-94ec-b34762e10d78)


---
### < 감상문 등록 & 전체 보기 >
- 제목, 저자, 감상문을 입력해서 저장
- 감상문 등록 (memo/upload.jsp)
- 감상문 전체 보기 (memo/diary.jsp)

![image](https://github.com/EunSung98/readMemo/assets/77737044/3233edc3-8cf4-4060-88fc-44fc1ba931f4)

---
### < 감상문 수정하기 >

- 제목, 저자, 감상문을 수정해서 저장
- 감상문 수정(memo/modify.jsp)

![image](https://github.com/EunSung98/readMemo/assets/77737044/de6498a7-ae43-413e-b832-a823fc18d237)


---
### < 감상문 삭제하기 >

- 삭제 버튼으로 삭제하기

![image](https://github.com/EunSung98/readMemo/assets/77737044/9d561d6a-33fb-4a8e-a30a-5f435a7ca62b)


---
### < 감상문 로그아웃, 아이디 저장 >

- 로그아웃 버튼으로 session에 있는 id 값 삭제
- 로그인 페이지의 아이디 저장으로 쿠키에 남은 id 값

![image](https://github.com/EunSung98/readMemo/assets/77737044/58f1976f-4761-4894-af66-223f10c2e4a8)

