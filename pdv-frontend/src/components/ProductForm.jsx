import axios from 'axios';
import { useState } from 'react';

function ProdutoForm() {
  const [produto, setProduto] = useState({
    codigo: "",
    tipoMaterial: "",
    name: "",
    preco: ""
  });

  const handleChange = (e) => {
    setProduto({ ...produto, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const resposta = await axios.post("http://localhost:8080/produtos", produto);
      console.log("Produto criado:", resposta.data);
      alert("Produto cadastrado com sucesso!");
    } catch (error) {
      console.error("Erro ao criar produto:", error);
      alert("Erro ao cadastrar produto!");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" name="codigo" placeholder="Código" onChange={handleChange} />
      <input type="text" name="tipoMaterial" placeholder="Tipo" onChange={handleChange} />
      <input type="text" name="name" placeholder="Nome" onChange={handleChange} />
      <input type="number" name="preco" placeholder="Preço" onChange={handleChange} />
      <button type="submit">Cadastrar Produto</button>
    </form>
  );
}

export default ProdutoForm;
