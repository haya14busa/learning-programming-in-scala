Chapter 06 Functional Objects
=============================

6.1 A specification for class Rational
--------------------------------------
- 有理数(分数) rational number
- 分子: numerator
- 分母: denominator

分数はImmutable

6.2 Constructing a Rational
---------------------------
```
class Rational(n: Int, d: Int)
```

- 中括弧`{}`省略化
- n,d -> クラスパラメータ class parameters
- これら2つのパラメータを取る基本コンストラクタ primary constructorsを生成する

### Immutable Objects
#### 長所
- 動作を推定しやすい
- コピーなどをする必要がなく、他のオブジェクトに渡せる
- 複数スレッドも安心
- ハッシュテーブルのキーを安全に構築できる

#### 欠点
- 大規模なオブジェクトグラフのコピーが必要になることがある

6.3 Reimplementing the toString method
--------------------------------------
- `override def`
- c.f. 10

6.4 Checking preconditions
--------------------------
- 0が分母にきたら、Rationalが作られないようにする
- 事前条件 precondition の定義
  - `require`

```
/** Tests an expression, throwing an `IllegalArgumentException` if false.
  *  This method is similar to `assert`, but blames the caller of the method
  *  for violating the condition.
  *
  *  @param requirement   the expression to test
  */
def require(requirement: Boolean) {
  if (!requirement)
    throw new IllegalArgumentException("requirement failed")
}
```

6.5 Adding fields
-----------------

- クラスパラメータはクラス内でのみ使える存在
- 自動的にfieldが作られるわけではない
- 外部からアクセスできるようになった

6.6 Self references
-------------------
- `this`
- 実行中のメソッドのレシーバであるオブジェクトインスタンスを参照する
- 省略可の場合と不可の場合がある

6.7 Auxiliary constructors
--------------------------
- 補助コンストラクター
- Rational(5, 1) -> Rational(5)

6.8 Private fields and methods
------------------------------
- `private def`

6.9 Defining operators
----------------------
- `*`の定義
- 中置記法

6.10 Identifiers in Scala
-------------------------
- キャメルケースを推奨
- アンダースコアは識別子には使わない
- クラスやトレイトでは先頭を大文字に
- 定数(constant)と`val`は違う
- magic number マジックナンバー
- mixed identifiers ミックス識別子
- literal identifiers リテラル識別子 バッククオート\`\`

6.11 Method overloading
-----------------------
- 型ごとに定義 -> overloading

6.12 Implicit conversion
------------------------
- `2 * r`に対応
- implicit def
- インタプリタのスコープに直接定義

6.13 A word of caution
----------------------
- 暗黙の型変換や演算子メソッドの使い方に注意

