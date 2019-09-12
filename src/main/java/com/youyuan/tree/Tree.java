package com.youyuan.tree;

/**
 * @author zhangyu
 * @version 1.0
 * @description 二叉树增删改查接口
 * @date 2018/11/5 19:56
 */
public class Tree {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 插入节点
     * @param data 节点数据项
     * @param sData 节点数据项
     */
    public void insertNode(long data,String sData){
        //封装成节点对象
        Node node=new Node(data,sData);
        if (root==null){
            root=node;
        }else {
            //当前节点
            Node current=root;
            while (true){
                //父节点
                Node parent=current;
                if (current.getData()>data){
                    current=current.getLeftChild();
                    if (current==null){
                        parent.setLeftChild(node);
                        break;
                    }
                }else {
                    current=current.getRightChild();
                    if (current==null){
                        parent.setRightChild(node);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 根据参数查询
     * @param data 参数
     * @return 返回查询结果node
     */
    public Node getNodeByData(long data){
        if (root!=null){
            if (root.getData()==data){
                return root;
            }else {
                Node current=root;
                while (current.getData()!=data){
                    if (current.getData()>data){
                        current=current.getLeftChild();
                    }else {
                        current=current.getRightChild();
                    }
                    if (current==null){
                        return null;
                    }
                }
                return current;
            }
        }
        return null;
    }

    /**
     * 前序遍历
     * @param localNode 根节点或子树的根节点
     */
    public void beforeNode(Node localNode){
        if (localNode!=null){
            //访问根节点
            System.out.println(localNode);
            //访问左树节点
            beforeNode(localNode.getLeftChild());
            //访问右树节点
            beforeNode(localNode.getRightChild());
        }
    }

    /**
     * 中序遍历
     * @param localNode 根节点或子树根节点
     */
    public void inNode(Node localNode){
        if (localNode!=null){
            //访问左树节点
            inNode(localNode.getLeftChild());
            //访问根节点
            System.out.println(localNode);
            //访问右树节点
            inNode(localNode.getRightChild());
        }
    }

    /**
     * 后序遍历
     * @param localNode 根节点或子树根节点
     */
    public void afterNode(Node localNode){
        if (localNode!=null){
            //访问左树节点
            afterNode(localNode.getLeftChild());
            //访问右树节点
            afterNode(localNode.getRightChild());
            //访问根节点
            System.out.println(localNode);
        }
    }

    /**
     * 根据参数删除节点
     * @param data 参数
     */
    public void delete(long data){
        //当前节点即要删除的节点
        Node current=root;
        //当前节点的父节点
        Node parent=root;
        //删除的节点是左节点还是右节点 true为左节点
        boolean isLeftChild=true;
        while(current.getData()!=data){
            parent=current;
            if (current.getData()>data){ //左节点查找
                current=current.getLeftChild();
                isLeftChild=true;
            }else { //右节点查找
                current=current.getRightChild();
                isLeftChild=false;
            }
            if (current==null){
                break;
            }
        }

        //以下为删除节点操作
        //1、删除叶子节点
        if (current.getLeftChild()==null && current.getRightChild()==null){
            //删除节点为根节点
            if (current==root){
                root=null;
            }else {
                if (isLeftChild){//删除的是左叶子节点
                    parent.setLeftChild(null);
                }else {//删除的是右叶子节点
                    parent.setRightChild(null);
                }
            }
        }else if (current.getRightChild()==null){//删除的是有左叶子节点的节点
            //删除节点为根节点
            if (current==root){
                current=current.getLeftChild();
            }else if (isLeftChild){//删除的是左节点
                parent.setLeftChild(current.getLeftChild());
            }else { //删除的是右节点
                parent.setRightChild(current.getLeftChild());
            }
        }else if (current.getLeftChild()==null){//删除的是有右叶子节点的节点
            //删除的节点为根节点
            if (current==root){
                root=current.getRightChild();
            }else if (isLeftChild){ //删除的是左节点
                parent.setLeftChild(current.getRightChild());
            }else {
                parent.setRightChild(current.getRightChild());
            }
        }else {//删除有两个节点的节点 需要查询出中序后继节点来替换当前要删除的节点
            Node successor=getSuccessor(current);//获取中序后继节点
            if (current==root){////删除的节点为根节点
                root=successor;
            }else if (isLeftChild){//删除的是左节点
                parent.setLeftChild(successor);
            }else { //删除的是右节点
                parent.setRightChild(successor);
            }
        }
    }

    /**
     * 获取中序后继节点
     * @param delNode 要删除的节点
     * @return 返回中序后继节点
     */
    private Node getSuccessor(Node delNode){
        //中序后继节点
        Node successor=delNode;
        //中序后继节点的父节点
        Node successorParent=delNode;
        //当前节点
        Node current=delNode.getRightChild();
        while (current!=null){
            successorParent=successor;
            successor=current;
            current=successor.getLeftChild();
        }
        if (successor!=delNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setLeftChild(delNode.getLeftChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.insertNode(20,"北京");
        tree.insertNode(12,"上海");
        tree.insertNode(98,"武汉");
        tree.insertNode(8,"南京");
        tree.insertNode(7,"桂林");
        tree.insertNode(16,"长春");
        tree.insertNode(13,"广州");
        tree.insertNode(18,"香港");
        tree.insertNode(28,"深圳");

        System.out.println(tree.root.getRightChild().getLeftChild());
        System.out.println(tree.root.getLeftChild().getRightChild());
        System.out.println("==============================");
        System.out.println(tree.getNodeByData(98));
        System.out.println(tree.getNodeByData(102));
        System.out.println("===========前序遍历============");
        tree.beforeNode(tree.root);
        System.out.println("===========中序遍历============");
        tree.inNode(tree.root);
        System.out.println("===========后序遍历============");
        tree.afterNode(tree.root);
        System.out.println("===========删除操作============");
        tree.delete(12);
        System.out.println("===========中序遍历============");
        tree.inNode(tree.root);
    }
}
