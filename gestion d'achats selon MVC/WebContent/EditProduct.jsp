<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>

<h3>Edit Product</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty product}">
    <form method="POST" action="${pageContext.request.contextPath}/editProduct">
        <input type="hidden" name="nom" value="${product.code}" />
        <table border="0">
            <tr>
                <td>Nom de produit</td>
                <td><input type="text" name="prix" value="${produit.nom}" /></td>
            </tr>
            <tr>
                <td>Prix</td>
                <td><input type="text" name="prix" value="${produit.prix}" /></td>
            </tr>
            <tr>
                <td>Fournisseur</td>
                <td><input type="text" name="fournisseur" value="${produit.fournisseur}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/ListeProduits">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>