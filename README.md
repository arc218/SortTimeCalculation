# SortTimeCalculation

新しいソートの追加方法

Sortを継承する。

引数にint型の配列を持つコンストラクタを作成し、その値を引数にして親クラスのコンストラクタを呼ぶ。

calc()をオーバーライドして中に固有の処理を追加する。

ソートの呼び出し

ControllerでSortの子クラスを引数にdoSort(sort)を呼ぶ
