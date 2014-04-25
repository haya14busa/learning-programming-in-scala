Chapter 05 Basic Types and Operations
=====================================

5.1 Some basic types
--------------------

### integral types
- Byte
- Short
- Int
- Long
- Char

### numeric types
- integral types
- Float
- Double

intは存在するが、intとIntは別物。また後者を推奨

5.2 Literals
------------
- リテラル literal: コードに定数値を直接書く書き方のこと

### 5.2.1 整数リテラル
- 0x, 0X -> 16 進数
- 0 -> 8進数 (deprecated)
- 末尾に`L` or `l` -> `Long`

### 5.2.2 浮動小数点数リテラル
```
scala> val big = 1.2345
big: Double = 1.2345

scala> val bigger = 1.2345e1
bigger: Double = 12.345

scala> val biggerStill = 123E45
biggerStill: Double = 1.23E47
```

- `e`は10の累乗
- 末尾が`f` or `F` -> `Float`

### 5.2.3 文字リテラル
- シングルクオート

```
scala> val a = 'A'
a: Char = A

scala> val c = '\101'
c: Char = A

scala> val d = '\u0041'
d: Char = A

scala> val B\u0041\u0044 = 1
BAD: Int = 1
```

### 5.2.4 文字列リテラル
- ダブルクオート
- raw string 生の文字列
  - `"""` 3つのダブルクオート
  - stripMarginで揃えられる

```
scala> println("""|Welcome to Ultamix 3000.
     |            |Type "HELP" for help. """.stripMargin)
Welcome to Ultamix 3000.
Type "HELP" for help.
```
### 5.2.5 シンボルリテラル
- `'ident` -> `scala.Symbol`のインスタンスにマッピングされる
- `Symbol("ident")`
- `intern`
- シンボルの実態は1つ!(文字列リテラルは毎回オブジェクトが生成される)

### 5.2.3 Boolean リテラル
- true
- false

5.3 Operators are methods
-------------------------
```
scala> 1 + 2 == (1).+(2)
res18: Boolean = true
```

Intは多重定義 overloaded された`+`メソッドを持つ

```
scala> 1 + 2L
res19: Long = 3
```

`+`などだけでなく、すべてのメソッドで中置(infix)記法が使える

- 前置(prefix)記法、後置(postfix)記法も

```
scala> -2.0 == (2.0).unary_-
res23: Boolean = true
```

### 前置記法
- +
- -
- !
- ~

### メソッド呼び出し
- 副作用がある場合には`()`をつける e.g. `pringln()`
- そうでなければ省略化 e.g. `String` の `toLowerCase`

5.4 Arithmetic operations
-------------------------
```
scala> 'b' - 'a'
res27: Int = 1
scala> 11 % 4
res29: Int = 3

scala> math.IEEEremainder(11.0, 4.0)
res30: Double = -1.0
```

5.5 Relational and logical operations
-------------------------------------
```
scala> def salt() = { println("salt"); false }
salt: ()Boolean

scala> def pepper() = { println("pepper"); true }
pepper: ()Boolean

scala> pepper && salt
pepper
salt
res32: Boolean = false

scala> salt && pepper
salt
res33: Boolean = false
```

名前渡しパラメーター by-name parametersによってすべてのメソッドが引数の評価を先延ばしにする

c.f. 9.5


5.6 Bitwise operations
----------------------
```
scala> 1 & 2
res34: Int = 0
```

- 1: 0001
- 2: 0010

ビットを対象として`AND`演算

- AND: `&`
- OR: `|`
- XOR: `^`
- bitの反転: `~`

### Shift
- `<<`
- `>>`
- `>>>` 符号なし右シフト

```
scala> 1 << 10
res41: Int = 1024
```

5.7 Object equality
-------------------
- `==`
- `!=`

5.8 Operator precedence and associativity
-----------------------------------------

5.9 Rich wrappers
-----------------
- implicit conversion 暗黙の型変換
- 基本型それぞれにRich wrapperが存在する















