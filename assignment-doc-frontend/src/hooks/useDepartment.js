import { useState, useEffect } from 'react'

export function useDepartments(id) {
    const [department, setDepartment] = useState(null)

    useEffect(() => {
        const controller = new AbortController()
        const signal = controller.signal

        fetch(`http://localhost:8080/departments/${id}`, { signal, method: "GET" })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Failed to fetch department with ID ${id}`)
                }
                return response.json()
            })
            .then(departmentData => setDepartment(departmentData))
            .catch(error => {
                if (error.name !== "AbortError") {
                    console.log(`Error fetching department data: ${error}`)
                }
            })

        return () => {
            controller.abort()
        }
    }, [id])

    return department
}
