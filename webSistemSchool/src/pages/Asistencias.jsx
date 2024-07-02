import React, { useState, useEffect } from 'react';
import axios from '../axiosConfig';

function Asistencias() {
    const [asistencias, setAsistencias] = useState([]);
    const [newAsistencia, setNewAsistencia] = useState({ fecha: '', estado: '', estudianteId: '' });

    useEffect(() => {
        fetchAsistencias();
    }, []);

    const fetchAsistencias = async () => {
        try {
            const response = await axios.get('/asistencias');
            setAsistencias(response.data);
        } catch (error) {
            console.error('Error al obtener asistencias', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewAsistencia({ ...newAsistencia, [name]: value });
    };

    const handleCreate = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/asistencias', newAsistencia);
            fetchAsistencias();
            setNewAsistencia({ fecha: '', estado: '', estudianteId: '' });
        } catch (error) {
            console.error('Error al crear asistencia', error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`/asistencias/${id}`);
            fetchAsistencias();
        } catch (error) {
            console.error('Error al eliminar asistencia', error);
        }
    };

    return (
        <div>
            <h1>Lista de Asistencias</h1>
            <ul>
                {asistencias.map(asistencia => (
                    <li key={asistencia.id}>
                        {asistencia.fecha} - {asistencia.estado} - {asistencia.estudianteId}
                        <button onClick={() => handleDelete(asistencia.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <form onSubmit={handleCreate}>
                <input
                    type="date"
                    name="fecha"
                    value={newAsistencia.fecha}
                    onChange={handleInputChange}
                    placeholder="Fecha"
                    required
                />
                <input
                    type="text"
                    name="estado"
                    value={newAsistencia.estado}
                    onChange={handleInputChange}
                    placeholder="Estado"
                    required
                />
                <input
                    type="number"
                    name="estudianteId"
                    value={newAsistencia.estudianteId}
                    onChange={handleInputChange}
                    placeholder="Estudiante ID"
                    required
                />
                <button type="submit">Agregar Asistencia</button>
            </form>
        </div>
    );
}

export default Asistencias;
