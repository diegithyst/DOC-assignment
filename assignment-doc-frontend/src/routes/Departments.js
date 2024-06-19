import { useDepartments } from "../hooks/useDepartments";

export default function Departments(){
    const departmentList = useDepartments()

    if (!departmentList) {
        return <div>Loading departments...</div>;
    }

    return (
        <div>
            <h2>List of Departments</h2>
            <ul>
                {departmentList.map(department => (
                    <li key={department.id}>
                        <strong>{department.name}</strong> - {department.description}
                    </li>
                ))}
            </ul>
        </div>
    );
}