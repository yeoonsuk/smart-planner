Week 1. 개발 환경 구축 및 프로젝트 초기 설정

🎯 목표
- 프로젝트 개발 환경 구축
- Spring Boot 프로젝트 생성
- Git 브랜치 전략 수립
- PostgreSQL(Supabase) 연동
- Health Check API 구현


✅ 진행 내용
1. 프로젝트 생성
  - Spring Boot 4
  - Java 21
  - Gradle
  - IntelliJ Ultimate

2. GitHub
  - Repository 생성
  -  GitHub Desktop 연동
  -  feature 브랜치 전략 적용
    main
     ├── feature/health-api
     ├── feature/database

3. 데이터베이스
- Supabase PostgreSQL 생성
- application.yml 연결
- JDBC 정상 연결 확인

4. API
GET /api/health

응답
{
  "status": "UP",
  "message": "Smart Planner API is running"
}



💡 트러블 슈팅
1. DataSource 연결 실패
  - 문제
    Failed to configure a DataSource
    url attribute is not specified

  - 원인
    application.yml에 spring.datasource 설정이 없었다.

  - 해결
    Supabase 정보를 추가
    <YAML>
    spring:
      datasource:
      url:
      username:
      password:

  - 배운 점
    JPA 의존성이 추가되면 Spring Boot는 DataSource를 자동 생성하려고 한다.


2. GitHub에 build 폴더가 올라가는 문제
  - 문제
    backend/build
    .idea
    .gradle
    등이 모두 Git에 올라가려고 했다.

  - 원인
    .gitignore를 잘못 작성한 것이 아니라
    .idea/.gitignore를 수정하고 있었다.
    Git이 읽는 파일은 프로젝트 루트/.gitignore 였다.

  - 해결
    루트의 .gitignore를 수정하고 이미 추적 중인 파일은
    git rm --cached로 추적을 제거했다.

  - 배운 점
    .gitignore은 새로운 파일만 무시하며 이미 Git이 추적 중인 파일은 별도로 추적 해제해야 한다.

3. feature 브랜치와 IntelliJ 연동
  - 문제
    GitHub Desktop에서 브랜치를 만들었지만 IntelliJ에는 main만 보였다.

  - 원인
    IntelliJ에서 브랜치를 Checkout하지 않았다.

  - 해결
    GitHub Desktop 또는 IntelliJ에서 동일한 브랜치로 Checkout

  - 배운 점
    브랜치를 생성(Create)하는 것과 브랜치를 사용하는(Checkout) 것은 다른 개념이다.

4. Health API 구현
  - 구현
    GET /api/health

  - 목적
    서버 실행 확인
    클라이언트 연결 확인
    이후 배포 테스트 시 Health Check 용도로 사용


📚 새롭게 배운 내용
- Spring Boot 프로젝트 구조
- Gradle과 Maven 차이
- Git Branch 전략
- JDK / Gradle JVM 관계
- Spring Boot Auto Configuration
- DataSource 자동 생성 과정
- .gitignore 동작 원리
- Git Tracking과 Ignore의 차이
- Supabase PostgreSQL 연결


회고
👍 잘한 점
- 개발 환경을 안정적으로 구축했다.
- Git 브랜치 전략을 초기에 적용했다.
- 데이터베이스 연결까지 완료하여 이후 개발 기반을 마련했다.
- 문제가 발생했을 때 원인을 하나씩 분석하며 해결했다.


🔧 개선할 점
- Git의 추적(Tracking)과 .gitignore의 동작 방식을 더 깊이 이해할 필요가 있다.
- 프로젝트 초기 설정 단계에서 필요한 환경 변수와 IDE 설정을 체크리스트로 관리하면
  시간을 절약할 수 있다.


🚀 다음 주 목표
- Smart Planner의 ERD 설계
- JPA Entity 작성
- Member API 구현
- Repository, Service, Controller 계층 설계
