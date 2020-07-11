function addRowHandlers() {
    var table = document.getElementById("events-table");
    var rows = table.getElementsByTagName("tr");
    for (i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler =
            function(row)
            {
                return function() {
                    var cell = row.getElementsByTagName("td")[0];
                    var id = cell.innerHTML;

                    window.location.href = "/event/" + id;


                }
            };
        currentRow.onclick = createClickHandler(currentRow);
    };


}
window.onload = addRowHandlers();





