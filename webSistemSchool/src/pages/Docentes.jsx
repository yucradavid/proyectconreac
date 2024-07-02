import React, { useState, useEffect } from 'react';
import axios from '../axiosConfig';

function Docentes() {
    const [docentes, setDocentes] = useState([]);
    const [newDocente, setNewDocente] = useState({ nombre: '', email: '' });

    useEffect(() => {
        fetchDocentes();
    }, []);

    const fetchDocentes = async () => {
        try {
            const response = await axios.get('/docentes');
            setDocentes(response.data);
        } catch (error) {
            console.error('Error al obtener docentes', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewDocente({ ...newDocente, [name]: value });
    };

    const handleCreate = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/docentes', newDocente);
            fetchDocentes();
            setNewDocente({ nombre: '', email: '' });
        } catch (error) {
            console.error('Error al crear docente', error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`/docentes/${id}`);
            fetchDocentes();
        } catch (error) {
            console.error('Error al eliminar docente', error);
        }
    };

    return (
        <div>
            <h1>Lista de Docentes</h1>
            <ul>
                {docentes.map(docente => (
                    <li key={docente.id}>
                        {docente.nombre} - {docente.email}
                        <button onClick={() => handleDelete(docente.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <form onSubmit={handleCreate}>
                <input
                    type="text"
                    name="nombre"
                    value={newDocente.nombre}
                    onChange={handleInputChange}
                    placeholder="Nombre"
                    required
                />
                <input
                    type="email"
                    name="email"
                    value={newDocente.email}
                    onChange={handleInputChange}
                    placeholder="Email"
                    required
                />
                <button type="submit">Agregar Docente</button>
            </form>
        </div>
    );
}

export default Docentes;
