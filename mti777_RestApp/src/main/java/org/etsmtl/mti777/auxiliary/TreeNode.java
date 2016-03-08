package org.etsmtl.mti777.auxiliary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.etsmtl.mti777.model.ItemCategory;

/*
 * Classe utilisada para gerar a árvore de categorias do menu em formato json
 * */
public class TreeNode {
	private Long id;
	private String name;
	private TreeNode parent;
	private List<TreeNode> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	

	/*
	 * O método que chama as duas funções responsáveis por criar a arvore da categoria do menu
	 * */
	public static String getTreeJson(List<ItemCategory> listItemCat) {
		List<TreeNode> myTree = getTree(listItemCat);
		String Json = "["+ geraJson(myTree.get(0)) +"]";
		return Json;
	}

	/*
	 * Através de a recursão, a função geraJson, gera o json da árvore de categorias
	 * Ela cria as porpriedades do nó atual e faz uma chamada recursiva para 
	 * os nós filhos
	 * */
	public static String geraJson(TreeNode node) {
		String Json = "{";
		Json += "\"id\": \"" + node.getId() + "\",";
		Json += "\"name\": \"" + node.getName() + "\",";
		if (node.getParent() != null) {
			Json += "\"parent\": \"" + node.getParent().getName() + "\"";
		} else {
			Json += "\"parent\": \"null\"";
		}
		if (node.children != null) {
			Json += ", \"children\": [";
			for(int i = 0; i < node.children.size(); i++){
				Json += geraJson(node.children.get(i));
				if(node.children.size() > 0 && i < node.children.size() -1 ) Json += ",";
			}
			Json += "]";
		}
		Json += "}";
		return Json;
	}

	/*
	 * Primeiro passo, gero o arvore de categoria do menu
	 * A chamada encontra o elemento raiz, e através de uma busca em profundidade
	 * o laço while constroi a árvore de treenodes
	 * */
	public static List<TreeNode> getTree(List<ItemCategory> listItemCat) {
		LinkedList<ItemCategory> queue = new LinkedList<ItemCategory>();
		LinkedList<TreeNode> queueTreeNode = new LinkedList<TreeNode>();

		ItemCategory root = getElement(listItemCat, null).get(0);

		List<TreeNode> myTree = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode();
		myTree.add(node);
		node.setId(root.getIditemCategory());
		node.setName(root.getName());
		List<TreeNode> nodeChildren;

		queue.push(root);
		queueTreeNode.push(node);

		while (!queue.isEmpty()) {
			ItemCategory itemCategoryFather = queue.pop();
			TreeNode nodeFather = queueTreeNode.pop();
			nodeChildren = new ArrayList<TreeNode>();

			for (ItemCategory itemCategory : getElement(listItemCat, itemCategoryFather)) {
				TreeNode nodeC = new TreeNode();
				nodeC.setId(itemCategory.getIditemCategory());
				nodeC.setName(itemCategory.getName());
				nodeC.setParent(nodeFather);
				nodeChildren.add(nodeC);
				nodeFather.setChildren(nodeChildren);

				queue.push(itemCategory);
				queueTreeNode.push(nodeC);
			}
		}

		return myTree;
	}

	public static List<ItemCategory> getElement(List<ItemCategory> listItemCat, ItemCategory father) {
		List<ItemCategory> categoryChildrens = new ArrayList<ItemCategory>();
		for (ItemCategory itemCategory : listItemCat) {
			if (itemCategory.getRootCategory() == father) {
				categoryChildrens.add(itemCategory);
			}
		}
		return categoryChildrens;
	}

}
