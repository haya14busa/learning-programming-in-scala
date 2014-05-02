Chapter 14 Assertions and Unit Testing
======================================

14.1 Assertions
---------------
- 表明
- `assert(<condition>)`
- `AssertionError`が投げられる
- `Predef`シングルトンオブジェクトで定義されている
- 2個の引数を指定できる。
  1. condition
  2. explanation: 説明を含む`AssertionError`を投げる

### ensuring
- `Predef`
- 暗黙の型変換により任意の結果型とともに使える
- 引数としてpredicate 述語関数をとる
  - パラメータ型として結果型をとり、`Boolean`で返す
- `true` -> 結果値を返す
- `false` -> `AssertionError`
- 表明はコンパイル時に無効化可能
  - `scalac -Xdisable-assertions`

14.2 Unit testing in Scala
--------------------------

### ScalaTest
- `org.scalatest.Suite`を拡張するクラスを書き、その中でテストメソッドを定義
- Suite テストスイート
