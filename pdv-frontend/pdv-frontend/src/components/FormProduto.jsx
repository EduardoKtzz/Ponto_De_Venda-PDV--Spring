// src/components/FormProduto.jsx
import React, { useState } from 'react';
import api from '../services/api';

const FormProduto = () => {
  const [formData, setFormData] = useState({
    codigo: '',
    tipoMaterial: '',
    name: '',
    preco: '',
    codigoDeBarras: ''
  });

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post('/produtos/', formData);
      alert('Produto cadastrado com sucesso!');
    } catch (err) {
      console.error(err);
      alert('Erro ao cadastrar produto.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" name="codigo" placeholder="Código" onChange={handleChange} required />
      <input type="text" name="tipoMaterial" placeholder="Tipo de Material" onChange={handleChange} required />
      <input type="text" name="name" placeholder="Nome" onChange={handleChange} required />
      <input type="number" step="0.01" name="preco" placeholder="Preço" onChange={handleChange} required />
      <input type="text" name="codigoDeBarras" placeholder="Código de Barras" onChange={handleChange} required />
      <input type="text" name="quantidadeEstoque" placeholder="Quantidade em estoque" onChange={handleChange} required />
      <button type="submit">Cadastrar</button>
    </form>
  );
};

export default FormProduto;
