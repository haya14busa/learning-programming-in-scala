Chapter 10 Composition and inheritance
======================================

10.1 A two-dimensional layout library
-------------------------------------
- コンビネータ conbinator: 同じドメインの要素を結合して新しい要素を作る合成演算子

10.2 Abstract classes
---------------------
```
abstract class Element {
  def contents: Array[String]
}
```

- contents: 抽象メンバー
  - 実装がない
- 抽象クラスのインスタンスは作れない
- 具象メソッド concreate method
- 宣言 declaration
- 定義 definition

Elementクラスのcontentsは抽象メソッドを**宣言**しているが、具象メソッドを**定義**していない

10.3 Defining parameterless methods
-----------------------------------

- パラメーターなしメソッド parameterless methods (e.g. def height: Int)
- <-> 空括弧メソッド empty-paren methods (e.g. def height(): Int)
- パラメータがなく、ミュータブルな状態を書き換えないならパラメーターなしメソッドを使うことを推奨
- 統一形式アクセスの原則 uniform access principle に従っている

10.4 Extending classes
----------------------
- サブクラスをつくる
- `extends`
- 継承 inherit

```
class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}
```

- ArrayElementはElementのサブ型(subtype)になる
- ElementはArrayElementのスーパークラス superclass
- `extends`がないと、暗黙のうちに`scala.AnyRef`を拡張しているとみなされる


### 継承 inheritance
- スーパークラスの非公開メンバーはサブクラスに継承されない
- すでにサブクラスで実装されているパラメータや同じ名前のメンバはスーパークラスから継承されない
  - これは「サブクラスのメンバがスーパークラスのメンバをoverrideする」と表現できる
- スーパークラスのメンバが抽象メンバで、サブクラスのメンバが具象メンバの場合は「具象メンバが抽象メンバを実装(implement)する」と表現する
- 合成 composition

10.5 Overriding methods and fields
----------------------------------

定義の名前空間は2個

1. 値(フィールド、メソッド、パッケージ、シングルトンオブジェクト)
2. 型(クラス、トレイト)

10.6 Defining parametric fields
-------------------------------
- `()`の中に`val`で定義。
- パラメータとフィールドの冗長性、繰り返しをなくし、パラメータとフィールドを結合している

10.7 Invoking superclass constructors
-------------------------------------
- スーパークラスに引数を渡す

10.8 Using override modifiers
-----------------------------
- 親クラスの具象メンバをオーバーライドするときに必要

10.9 Polymorphism and dynamic binding
--------------------------------------
- サブ型による多相性(subtyping polymorphism)
- 普遍的な多層性(universal polymorphism)
  - ジェネリック c.f. 19
- 動的束縛 ダイナミックバインディング dynamic binding

10.10 Declaring final members
-----------------------------
- overrideできないようにする
- ファイナルメソッド final methods
- ファイナルクラス final class
  - クラス全体のサブクラス化を禁止

10.11 Using composition and inheritance
---------------------------------------
- `is-a` 関係

10.12 Implementing above, beside, toString
-----------------------------------
- `Seq`, 配列のメソッド c.f. 17


10.13 Defining a factory object
-------------------------------
- newで直接オブジェクトを作るのではなく、ファクトリーオブジェクトを使って生成するようにする
- オブジェクトの階層を隠蔽できる
- どこに実装するか
  - シンプルで素直にやれば Elementクラスのコンパニオンオブジェクトを作る


10.14 Highten and widen
-----------------------

10.15 Putting it all together
-----------------------------










