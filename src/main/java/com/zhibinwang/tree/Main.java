package com.zhibinwang.tree;

import com.zhibinwang.tree.printer.BinaryTrees;

import javax.sound.midi.Soundbank;
import java.nio.file.Files;
import java.util.Comparator;

/**
 * @author 花开
 * @create 2020-06-14 10:00
 * @desc 测试方法
 **/
public class Main {
    private static class PersonComparator implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    private static class PersonComparator2 implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    static void test1() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
    }

    static void test2() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }

        BinaryTrees.println(bst1);

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }
        BinaryTrees.println(bst2);
    }

    static void test3() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);


    }

    static  void  test4(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);

        /**
         * 回调函数

        bst.leverOrder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public void excute(Integer element) {
                System.out.println(element);
            }
        }); */
    }

    public static void test5(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int)(Math.random() * 100));
        }

        System.out.println(bst.height());

        System.out.println(bst.height1());
    }
    static void test6() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

//		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//		for (int i = 0; i < 10; i++) {
//			bst.add((int)(Math.random() * 100));
//		}
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());

        // bst.levelOrderTraversal();

		/*
		 *       7
		 *    4    9
		    2   5
		 */

//		bst.levelOrder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + element + "_ ");
//			}
//		});

//		bst.inorder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + (element + 3) + "_ ");
//			}
//		});

        // System.out.println(bst.height());
    }
    static void test8() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());
    }


    static void test9() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
       // System.out.println(bst.isComplete());
        bst.remove(9);

        BinaryTrees.println(bst);
    }

    static void test10() {
        Integer data[] = new Integer[] {
                13,14,15,12,11,17,16,8,9,1
        };

        AvlTree<Integer> avl = new AvlTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(avl);
			System.out.println("---------------------------------------");
        }
        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------------");
        }


//		for (int i = 0; i < data.length; i++) {
//			avl.remove(data[i]);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
//		}


      // BinaryTrees.println(avl);
    }

    static void test11() {
        Integer data[] = new Integer[] {
                23, 67, 97, 100, 95, 82, 4, 10, 78, 24, 91, 54, 85, 38, 87
        };

        RBTree<Integer> rbTree = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rbTree);
            System.out.println("---------------------------------------");
        }
/*        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rbTree);
            System.out.println("---------------------------------------");
        }*/


//		for (int i = 0; i < data.length; i++) {
//			avl.remove(data[i]);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
//		}


        // BinaryTrees.println(avl);
    }


    public static void main(String[] args) {
       // test1();

        test11();

     //   test6();

    }
}
