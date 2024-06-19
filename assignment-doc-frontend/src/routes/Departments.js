import { useAddStory } from "../hooks/addStory";
import { useDepartments } from "../hooks/useDepartments";
import { useStories } from "../hooks/useStories";

export default function Departments(){
    const departmentList = useDepartments()
    useAddStory("Story1", "THis is a story 1", 1)
    const stories = useStories(1);


    console.log(stories)

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