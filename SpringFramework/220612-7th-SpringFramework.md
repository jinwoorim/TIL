## Transaction 

- 분리될 수 없는 작업단위

- 모든 작업이 성공하거나 실패해야됨

## Transaction 관리

- 등록, 수정, 삭제 했을 때 중간에 잘못되면 commit 되지않고 rollback되어야한다

## Transaction 설정(Spring이 제공해준다)

- 네임스페이스 추가

- XML에 bean 등록

- XML에 tx:advice 설정

- XML에 Pointcut 과 advisor 설정
