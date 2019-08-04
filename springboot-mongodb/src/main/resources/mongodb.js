var names = db.getCollectionNames();

// -- Create Collections --
if (!names.includes('students')) {
    db.createCollection("students", {});
    print("create collection students");
}
if (!names.includes('scores')) {
    db.createCollection("scores", {});
    print("create collection scores");
}
// -----------------------------


// -- Create students indexes --
var studentsIndexNames = db.userRoles.getIndexes().map(function (i) {
    return i.name
});

if (!studentsIndexNames.includes('unique_name_address')) {
    db.students.createIndex({
        "name": 1,
        "address": 1
    }, {
        name: "unique_name_address",
        background: true,
        unique: true
    });
    print('create students index unique_name_address');
}

// -- Create scores indexes --
var scoresIndexNames = db.scores.getIndexes().map(function (i) {
    return i.name
});

if (!scoresIndexNames.includes('unique_studentId_subject')) {
    db.scores.createIndex({
        "studentId": 1,
        "subject": 1
    }, {
        name: "unique_studentId_subject",
        background: true,
        unique: true
    });
    print('create scores index unique_studentId_subject');
}

// -----------------------------
// -- students data init --
// -----------------------------
var studentsResult = db.students.findOne({"name": "Even"});
if (studentsResult == null) {
    db.students.insert({
        "name": "Even",
        "age": 11,
        "sex": "Male",
        "address": "Xian",
        "hobbies": ["YuWen", "English"]
    });
}
