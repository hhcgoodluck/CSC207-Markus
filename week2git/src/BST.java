/**
 * A minimal implementation of a binary search tree storing Integers.
 * See the Python version for additional documentation; we haven't copied over any docstrings here.
 * You can also see
 * <a href="https://www.teach.cs.toronto.edu/~csc148h/notes/binary-search-trees/bst_implementation.html">CSC148 Course Notes Section 8.5 BST Implementation and Search</a>
 * if you want a refresher on BSTs, but it is not required to complete this assignment.
 */
public class BST {
    private Integer root;
    private BST left;
    private BST right;

    public BST(Integer root) {
        if (root == null) {
            this.root = null;
            this.left = null;
            this.right = null;
        } else {
            this.root = root;
            this.left = new BST(null);
            this.right = new BST(null);
        }
    }

    public BST() {
        this(null);
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(Integer item) {
        // provided code; do not change
        if (this.isEmpty()) {
            return false;
        } else if (item.equals(this.root)) { // see comment below
            // In general, we need to use .equals and not == to properly compare values.
            // Since we are storing integers, one _could_ implement this class such that
            // using == would be fine instead, but that has not been done here since we
            // are using Integer objects.
            return true;
        } else if (item.compareTo(this.root) < 0) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }


    public void insert(Integer item) {
        if (this.isEmpty()) {
            // 如果树为空，将根节点设为要插入的项
            this.root = item;
            this.left = new BST(null); // 创建新的左子树
            this.right = new BST(null); // 创建新的右子树
        } else if (item.compareTo(this.root) <= 0) {
            // 如果要插入的项小于或等于根节点，递归插入到左子树
            this.left.insert(item);
        } else {
            // 如果要插入的项大于根节点，递归插入到右子树
            this.right.insert(item);
        }
    }


    public void delete(Integer item) {
        if (this.isEmpty()) {
            // 树为空
            return;
        } else if (item.equals(this.root)) {
            // 当前节点是要删除的节点，调用 deleteRoot 方法
            this.deleteRoot();
        } else if (item.compareTo(this.root) < 0) {
            // 要删除的节点小于根节点，递归到左子树
            this.left.delete(item);
        } else {
            // 要删除的节点大于根节点，递归到右子树
            this.right.delete(item);
        }
    }

    private void deleteRoot() {
        // 前提条件 当前树非空
        if (this.left.isEmpty() && this.right.isEmpty()) {
            // 如果左右子树都为空，设置根为 null
            this.root = null;
            this.left = null;
            this.right = null;
        } else if (this.left.isEmpty()) {
            // 如果左子树为空，提升右子树
            BST carrier = this.right;
            this.root = carrier.root;
            this.left = carrier.left;
            this.right = carrier.right;
        } else if (this.right.isEmpty()) {
            // 如果右子树为空，提升左子树
            BST carrier = this.left;
            this.root = carrier.root;
            this.right = carrier.right;
            this.left = carrier.left;
        } else {
            // 两个子树都非空，从左子树提取最大值替换根
            this.root = this.left.extractMax();
        }
    }


    private Integer extractMax() {
        if (this.right.isEmpty()) {
            // 如果右子树为空，当前节点是最大值
            Integer maxItem = this.root;
            BST tempLeft = this.left;
            // 记录最大值
            this.root = tempLeft.root;
            this.left = tempLeft.left;
            this.right = tempLeft.right;
            // 提升左子树
            return maxItem;
            // 返回最大值
        } else {
            // 递归查找右子树的最大值
            return this.right.extractMax();
        }
    }

    public int height() {
        if (this.isEmpty()) {
            // 如果树为空，返回高度 0
            return 0;
        } else {
            // 返回左右子树高度的最大值加 1
            return Math.max(this.left.height(), this.right.height()) + 1;
        }
    }

    public int count(Integer item) {
        if (isEmpty()) {
            // 检查树是否为空
            return 0;
        }else if (this.root > item) {
            // 比较根节点值与待查找的 item
            return this.left.count(item);
            // 在左子树递归查找
        } else if (this.root.equals(item)) {
            // 计算当前节点并在左右子树递归查找
            return 1 + this.left.count(item) + this.right.count(item);
        } else {
            // 在右子树递归查找
            return this.right.count(item);
        }
    }

    public int getLength() {
        if (isEmpty()) {
            // 检查树是否为空
            return 0;
        }
            // 计算当前节点和左右子树的节点数
        return 1 + left.getLength() + right.getLength();
    }

    public static void main(String[] args) {
        // Important: do not add any code to a "psvm" main method in this class,
        //            as it may prevent your code from running on MarkUs.
        //            If you want to test this code, you can either create a test file
        //            similar to the provided BSTSelfTest.java or create a main method
        //            in a local .java file which you don't push to MarkUs.
        //            In particular, if you include any code on MarkUs which calls:
        //            new Integer(x); // for any x
        //            then your code won't be able to be compiled and run, with an error
        //.            similar to:
        //            "warning: [removal] Integer(int) in Integer has been deprecated and marked for removal"
    }

}
