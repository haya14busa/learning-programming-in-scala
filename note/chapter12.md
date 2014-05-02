Chapter 12 Traits
=================


- trait: 特徴、特性、形質
- 再利用の基本単位
- クラスにmixinできる


12.1 How traits work
--------------------

- `extends` or `with` でclassにmixin conpositionする
- c.f. 12.6
- 型も定義される

### traitとclassの違い
- クラスパラメータを取れない c.f. 20.5
- super呼び出しがクラスでは静的に束縛されるのに対し、traitは動的に束縛される

12.2 Thin versus rich interfaces
--------------------------------
- thin: 薄い、貧弱
- thin -> rich interfacesにすることがtraitによって容易になる

12.3 Example: Rectangular objects
---------------------------------

12.4 The Ordered trait
----------------------
- `Ordered` traitと`compare` methodを一つ定義するだけで `<`, `>`, `<=`, `>=`の4つのメソッドが定義される
- 型パラメータ tyupe parameters を指定する必要がある
- `Ordered[C]` where `C` is the name of the class
- `equals`, `==`は自分で定義する必要がある。 c.f. 30

12.5 Traits as stackable modifications
--------------------------------------
- taritsは積み重ね可能な変更 stackable modifications


### Queue
考えられうるtraits

1. double
2. increment
3. filtering


```scala
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}
```

- `Doubling` は`IntQueue`をsuperクラスとして宣言しているので、`IntQueue`型しかこのトレイトをmixinできない
- abstract宣言されたメソッドで`super`呼び出しをしている
  - これは普通のクラスではコンパイルは通らない
  - `super`呼び出しが動的に束縛されているので正しく機能
  - これを示すためには`abstract override`と宣言する必要がある
- traitのmixinの順番で柔軟に動作を変更できる

12.6 Why not multiple inheritance?
----------------------------------
- trait: super呼び出しによって呼び出されるメソッドは線形化(linearization)した結果によって決まる

12.7 To trait, or not to trait?
-------------------------------
- 複数の無関係なクラスで再利用される -> trait


12.8 Conclution
---------------
- [Gyazo - 48dde83712fca7216326645af80335bb.png](http://gyazo.com/48dde83712fca7216326645af80335bb)
- [Scalaのコミッターの人が「Cake Patternはアンチパターンだ」と言って話題に！ - Togetterまとめ](http://togetter.com/li/539827)
