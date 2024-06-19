export function useAddStory() {
    const addStory = async (name, description, departmentId) => {
        const newStory = { name, description, departmentId };
        const response = await fetch(`http://localhost:8080/stories`, {
            body: JSON.stringify(newStory),
            headers: {
                "Content-Type": "application/json"
            },
            method: "POST"
        });
        if (response.ok) {
            const data = await response.json();
            alert("Story added successfully");
            return data; // Return data if needed
        } else {
            alert("Error adding a story");
            throw new Error('Error adding a story'); // Optionally handle errors
        }
    };

    return addStory;
}
