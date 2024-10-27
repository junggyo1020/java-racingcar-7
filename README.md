# 🚗 미션 - 자동차 경주 게임
## 💡 핵심 기능
### What
- 주어진 횟수 동안 여러 대의 자동차가 전진하거나 멈추는 간단한 자동차 경주 게임 기능을 구현한다.

### How
- 각 자동차는 무작위로 0에서 9 사이의 숫자를 얻고, 그 값이 4 이상일 경우 전진한다.
- 자동차의 이름은 사용자가 지정하며, 게임이 끝난 후 우승자를 출력한다.

### Why
- 단순한 규칙과 무작위성을 통해 게임의 재미를 더하며, 사용자에게 직접 자동차 이름을 설정할 수 있도록 하여 게임 참여도를 높인다.
- 최종 우승자를 알 수 있도록 하여 사용자에게 경쟁의 재미를 제공한다.

<br/>

## ⛳️ 2주차 목표
- 프로그램 구현 시 `한번 더 생각하기` (프리코스 목표)
- 객체 지향에 대해 생각하면서, `확장이 용이`한 프로그램을 구현하는 것을 목표로 한다.
- `SRP(단일 책임 원칙)`을 따라 하나의 기능만 수행하는 작은 함수로 큰 함수들을 분리한다.
- `JUnit 5` 및 `AssertJ`를 사용하여 테스트를 작성하고 프로그램이 제대로 작동하는지 검증한다.

<br/>

## ✏️ 구현할 기능 목록
### 1. 사용자 입력 처리
- [ ] 경주할 자동차 이름을 입력받는다.
    - [ ] 빈 문자열이나 null을 발생시킬 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
- [ ] 쉼표(,)로 구분된 이름들을 리스트로 변환한다.
- [ ] 경주할 횟수를 입력받아 정수로 변환한다. 
    - [ ] 숫자가 아닌 문자를 입력할 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
    - [ ] 사용자가 1보다 작은 정수를 입력할 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
---
### 2. 자동차 이름 유효성 검증
- [ ] 입력된 이름이 비어있거나 5자를 초과하는 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
---
### 3. 자동차 전진 조건 설정
- [ ] 0에서 9 사이의 무작위 값을 생성한다.
- [ ] 해당 값이 4 이상일 경우 자동차가 전진한다.
    - [ ] 무작위 값이 0에서 0 사이가 아닌 값이 들어올 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
---
### 4. 게임 진행 및 결과 출력
- [ ] 각 라운드별로 각 자동차의 전진 결과를 출력한다.
---
### 5. 우승자 판별 및 출력
- [ ] 모든 라운드가 끝난 후, 가장 멀리 전진한 자동차를 우승자로 설정한다.
- [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.
---
### 6. 예외 처리
- [ ] 모든 사용자 입력에서 IllegalArgumentException을 발생시키는 상황에 대해 예외 메시지를 출력한다.
    - [ ] 자동차 이름: `자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`
    - [ ] 시도 횟수: `시도 횟수는 1 이상의 정수로 입력해야 합니다.`
    - [ ] 무작위 값 범위: `전진 조건을 설정하는 값은 0에서 9 사이여야 합니다.`
---
<br/>

## 📦 역할 별 패키지 분리
### domain
- `Car`: 각 자동차의 상태와 전진 기능을 관리
- `CarRacing`: 레이스 전체 흐름과 진행을 관리
- `RandomNumberGenerator`: 무작위 숫자 생성 기능을 제공
---
### view
- `InputView`: 사용자로부터 입력을 받는 역할
- `OutputView`: 게임 진행 상황과 결과를 출력하는 역할
---
### controller
- `RacingController`: 전체 게임 흐름을 제어하고, 레이스의 각 단계를 조정 
---
### exception
- `ErrorMessage`: 예외 메시지 관리를 위한 열거형
- `CarRacingException`: IllegalArgumentException을 상속받아 예외 메시지를 관리
---
### validator
- `CarNameValidator`: 자동차 이름의 유효성을 검사 
    - 이름 길이 및 공백 여부 등 기본 조건을 검사
- `TrialCountValidator`: 시도 횟수 입력의 유효성을 검사
    - 양의 정수인지 확인하고, 유효하지 않다면 예외를 발생
- `RandomNumberGenerator` : 무작위 값이 0에서 9 사이인지 검사
- `ValidatorManager`: `CarNameValidator`와 `TrialCountValidator`, `RandomNumberGenerator`를 종합하여 입력값을 최종 검증
    - 단일 Validator 클래스를 호출하는 대신, 각 Validator에 역할을 위임하여 검증 로직을 관리
---

## ✅ 과제 진행 요구 사항
- [ ] 저장소 Fork 및 Clone: 자동차 경주 게임 저장소를 Fork하고 Clone하여 시작
- [ ] README.md 기능 목록 추가: 구현할 기능 목록을 작성하여 추가
- [ ] Commit 및 PR: 기능 단위로 커밋하고, 최종 Pull Request를 제출 
---
## ✅ 프로그래밍 요구 사항
### 제출 전 확인 리스트
- [ ] `JDK 21`을 사용하여 프로그램이 실행되는지 확인한다.
- [ ] 프로그램 시작점은 `Application`의 main() 메서드이다.
- [ ] `build.gradle` 파일을 수정하지 않으며, 제공된 라이브러리 외 추가 라이브러리를 사용하지 않는다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
### 라이브러리 요구 사항
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console API`를 사용하여 구현해야 한다.
  - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.







