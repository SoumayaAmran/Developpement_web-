<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un produit</title>
    <h3>Ajouter un produit</h3>

<form method="POST" action="${pageContext.request.contextPath}/createProduct">
    <table border="0">
        <tr>
            <td>Nom de produit</td>
            <td><input type="text" name="nom" value="${product.code}" /></td>
        </tr>
        <tr>
            <td>Prix</td>
            <td><input type="text" name="prix" value="${product.name}" /></td>
        </tr>
        <tr>
            <td>Fournisseur</td>
            <td><input type="text" name="fournisseur" value="${product.price}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="ListeProduits">Cancel</a>
            </td>
        </tr>
    </table>
    <title>Liste des produits</title>
</head>
<body>

<h3>ListeProduits</h3>
<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>nom de produit</th>
        <th>prix</th>
        <th>fournisseur</th>
        <th>Modifier</th>
        <th>Supprimer</th>
    </tr>
    <c:forEach items="${ListeProduits}" var="produit" >
        <tr>
            <td>${produit.nom}</td>
            <td>${produit.prix}</td>
            <td>${produit.fournisseur}</td>
            <td>
                <a href="editProduit?code=${product.code}">Modifier</a>
            </td>
            <td>
                <a href="deleteProduit?code=${product.code}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<br>

</body>
</html>