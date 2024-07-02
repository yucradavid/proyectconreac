import React, { useState, useEffect } from 'react';
import axios from '../axiosConfig';

function Reportes() {
    const [reportes, setReportes] = useState([]);
    const [newReporte, setNewReporte] = useState({ titulo: '', descripcion: '' });

    useEffect(() => {
        fetchReportes();
    }, []);

    const fetchReportes = async () => {
        try {
            const response = await axios.get('/reportes');
            setReportes(response.data);
        } catch (error) {
            console.error('Error al obtener reportes', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewReporte({ ...newReporte, [name]: value });
    };

    const handleCreate = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/reportes', newReporte);
            fetchReportes();
            setNewReporte({ titulo: '', descripcion: '' });
        } catch (error) {
            console.error('Error al crear reporte', error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`/reportes/${id}`);
            fetchReportes();
        } catch (error) {
            console.error('Error al eliminar reporte', error);
        }
    };

    return (
        <div>
            <h1>Lista de Reportes</h1>
            <ul>
                {reportes.map(reporte => (
                    <li key={reporte.id}>
                        {reporte.titulo} - {reporte.descripcion}
                        <button onClick={() => handleDelete(reporte.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <form onSubmit={handleCreate}>
                <input
                    type="text"
                    name="titulo"
                    value={newReporte.titulo}
                    onChange={handleInputChange}
                    placeholder="Título"
                    required
                />
                <textarea
                    name="descripcion"
                    value={newReporte.descripcion}
                    onChange={handleInputChange}
                    placeholder="Descripción"
                    required
                />
                <button type="submit">Agregar Reporte</button>
            </form>
        </div>
    );
}

export default Reportes;
