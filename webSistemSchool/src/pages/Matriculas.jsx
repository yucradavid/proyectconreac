import React, { useState, useEffect } from 'react';
import axios from '../axiosConfig';

function Matriculas() {
    const [matriculas, setMatriculas] = useState([]);
    const [newMatricula, setNewMatricula] = useState({ fechaMatricula: '', estado: '', estudianteId: '' });

    useEffect(() => {
        fetchMatriculas();
    }, []);

    const fetchMatriculas = async () => {
        try {
            const response = await axios.get('/matriculas');
            setMatriculas(response.data);
        } catch (error) {
            console.error('Error al obtener matriculas', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewMatricula({ ...newMatricula, [name]: value });
    };

    const handleCreate = async (e) => {
        e.preventDefault();
        try {
            await axios.post('/matriculas', newMatricula);
            fetchMatriculas();
            setNewMatricula({ fechaMatricula: '', estado: '', estudianteId: '' });
        } catch (error) {
            console.error('Error al crear matricula', error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`/matriculas/${id}`);
            fetchMatriculas();
        } catch (error) {
            console.error('Error al eliminar matricula', error);
        }
    };

    return (
        <div>
            <h1>Lista de Matriculas</h1>
            <ul>
                {matriculas.map(matricula => (
                    <li key={matricula.id}>
                        {matricula.fechaMatricula} - {matricula.estado} - {matricula.estudianteId}
                        <button onClick={() => handleDelete(matricula.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <form onSubmit={handleCreate}>
                <input
                    type="date"
                    name="fechaMatricula"
                    value={newMatricula.fechaMatricula}
                    onChange={handleInputChange}
                    placeholder="Fecha Matricula"
                    required
                />
                <input
                    type="text"
                    name="estado"
                    value={newMatricula.estado}
                    onChange={handleInputChange}
                    placeholder="Estado"
                    required
                />
                <input
                    type="number"
                    name="estudianteId"
                    value={newMatricula.estudianteId}
                    onChange={handleInputChange}
                    placeholder="Estudiante ID"
                    required
                />
                <button type="submit">Agregar Matricula</button>
            </form>
        </div>
    );
}

export default Matriculas;
