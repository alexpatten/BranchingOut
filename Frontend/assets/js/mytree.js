// Sample family data
const familyData = [
    { name: "Grandparent 1", children: ["Parent 1", "Parent 2"] },
    { name: "Parent 1", children: ["You"] },
    { name: "Parent 2", children: ["Sibling 1", "Sibling 2"] },
    { name: "Sibling 1", children: [] },
    { name: "Sibling 2", children: [] },
];

// Function to create a person element
function createPerson(name) {
    const personElement = document.createElement("div");
    personElement.classList.add("person");
    personElement.textContent = name;
    return personElement;
}

// Function to create the family tree
function createFamilyTree(data) {
    const familyTreeElement = document.querySelector(".family-tree");

    data.forEach((personData) => {
        const personElement = createPerson(personData.name);
        familyTreeElement.appendChild(personElement);

        // Recursively create children for each person
        personData.children.forEach((childName) => {
            const childData = data.find((person) => person.name === childName);
            if (childData) {
                const childElement = createPerson(childData.name);
                personElement.appendChild(childElement);
            }
        });
    });
}

// Call the function with your family data when the document is fully loaded
document.addEventListener("DOMContentLoaded", function () {
    createFamilyTree(familyData);
});