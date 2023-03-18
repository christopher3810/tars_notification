![Java](https://img.shields.io/badge/language-Java-blue) ![Spring Webflux](https://img.shields.io/badge/framework-Spring_Webflux-brightgreen) ![PostgreSQL](https://img.shields.io/badge/database-PostgreSQL-blue) \
![Redis](https://img.shields.io/badge/cache-Redis-red) ![Kafka](https://img.shields.io/badge/message_broker-Kafka-orange) ![Prometheus](https://img.shields.io/badge/monitoring-Prometheus-purple) ![Grafana](https://img.shields.io/badge/visualization-Grafana-yellowgreen)

![tars-noti](https://user-images.githubusercontent.com/61622657/226113256-f64492b9-7a53-4551-b042-0e3d5f8963b9.gif)

interstella 의 tars를 모티브로 했습니다. \
사용자가 원하는 주식 정보를 이메일로 받아볼 수 있도록 등록하고 설정하는 서비스 입니다.

## 목차

-   [서비스 개념](https://chat.openai.com/chat?model=gpt-4#%EC%84%9C%EB%B9%84%EC%8A%A4-%EA%B0%9C%EB%85%90)
    -   [초기 목표](https://chat.openai.com/chat?model=gpt-4#%EC%B4%88%EA%B8%B0-%EB%AA%A9%ED%91%9C)
-   [서비스 아키텍처](https://chat.openai.com/chat?model=gpt-4#%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98)
    -   [Mermaid 코드로 작성된 서비스 아키텍처](https://chat.openai.com/chat?model=gpt-4#mermaid-%EC%BD%94%EB%93%9C%EB%A1%9C-%EC%9E%91%EC%84%B1%EB%90%9C-%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98)
-   [주요 기능](https://chat.openai.com/chat?model=gpt-4#%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5)
-   [설치 필요 사항](https://chat.openai.com/chat?model=gpt-4#%EC%84%A4%EC%B9%98-%ED%95%84%EC%9A%94-%EC%82%AC%ED%95%AD)

### 초기 목표

1.  사용자 등록 및 로그인 기능 구현
2.  관심 주식 선택 및 관리 기능 구현
3.  이메일 알림 시간 설정 기능 구현
4.  주기적인 주식 데이터 업데이트 및 캐싱
5.  서비스 모니터링 및 경고 기능 구현

## 서비스 아키텍처

### 서비스 아키텍처
```mermaid
graph LR
  A[사용자 웹 인터페이스] -- API 요청 --> B[사용자 등록 및 인증 서비스]
  B -- 사용자 정보 저장 --> C[PostgreSQL]
  A -- API 요청 --> D[주식 선택 서비스]
  D -- 주식 정보 저장 --> C
  A -- API 요청 --> E[이메일 스케줄링 서비스]
  E -- 이메일 이벤트 --> F[Apache Kafka]
  G[이메일 전송 서비스] -- 이메일 전송 --> H[SMTP 서버]
  F -- 이메일 이벤트 --> G
  I[주식 데이터 서비스] -- 주식 데이터 요청 --> J[Open API]
  J -- 주식 데이터 응답 --> I
  I -- 주식 데이터 저장 --> K[Reactive Redis]
  L[Prometheus] -- 모니터링 --> M[서비스]
  N[Grafana] -- 시각화 및 경고 --> L

```



## 주요 기능

1.  사용자 등록 및 로그인
2.  관심 주식 선택
3.  이메일 알림 시간 설정
4.  주식 데이터 업데이트 및 캐싱
5.  서비스 모니터링 및 경고
