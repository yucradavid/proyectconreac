import React, { useState, useEffect } from 'react';
import axios from '../axiosConfig';

function Estudiantes() {
    const [estudiantes, setEstudiantes] = useState([]);
    const [newEstudiante, setNewEstudiante] = useState({ nombre: '', email: '' });

    useEffect(() => {
        fetchEstudiantes();
    }, []);

    const fetchEstudiantes = async () => {
        try {
            const response = await axios.get('/estudiantes');
            setEstudiantes(response.data);
        } catch (error) {
            console.error('Error al obtener estudiantes', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewEstudiante({ ...newEstudiante, [name]: value });
    };

    const handleCreate = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/estudiantes', newEstudiante);
            fetchEstudiantes();
            setNewEstudiante({ nombre: '', email: '' });
        } catch (error) {
            console.error('Error al crear estudiante', error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`/estudiantes/${id}`);
            fetchEstudiantes();
        } catch (error) {
            console.error('Error al eliminar estudiante', error);
        }
    };

    return (
        <div>
            <h1>Lista de Estudiantes</h1>
            <ul>
                {estudiantes.map(estudiante => (
                    <li key={estudiante.id}>
                        {estudiante.nombre} - {estudiante.email}
                        <button onClick={() => handleDelete(estudiante.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <form onSubmit={handleCreate}>
                <input
                    type="text"
                    name="nombre"
                    value={newEstudiante.nombre}
                    onChange={handleInputChange}
                    placeholder="Nombre"
                    required
                />
                <input
                    type="email"
                    name="email"
                    value={newEstudiante.email}
                    onChange={handleInputChange}
                    placeholder="Email"
                    required
                />
                <button type="submit">Agregar Estudiante</button>
            </form>
        </div>
    );
}

export default Estudiantes;
