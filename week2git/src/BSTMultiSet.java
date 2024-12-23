public class BSTMultiSet extends MultiSet {

    // a multiset always starts empty, so we can directly instantiate our private attribute
    // here; no need to explicitly write a new constructor.
    private final BST bst = new BST(null);

    @Override
    void add(Integer item) {
        bst.insert(item); // 调用 BST 的插入方法
    }

    @Override
    void remove(Integer item) {
        bst.delete(item); // 调用 BST 的删除方法
    }

    @Override
    boolean contains(Integer item) {
        return bst.contains(item); // 调用 BST 的查找方法
    }

    @Override
    boolean isEmpty() {
        return bst.isEmpty(); // 调用 BST 的空检查方法
    }

    @Override
    int count(Integer item) {
        return bst.count(item); // 调用 BST 的计数方法
    }

    @Override
    int size() {
        return bst.getLength(); // 调用 BST 的大小方法
    }

    //            hover the red squiggly on the first line and select 'Implement methods'.
    //            All listed methods should be selected. Press okay and then implement each
    //            method. As with the python version, this shouldn't require a lot of code to write.
    //
    //            Hint: autocomplete will help as you look for the right bst methods to call,
    //                  but make sure to double-check that you are calling the correct methods!
    //
    //            Note: if the red squiggly line isn't there, make sure src is marked as
    //                  the sources root; if it still isn't there, you will just need to manually
    //.                  copy over the method headers from MultiSet.java to be implemented.
}
