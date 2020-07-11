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
                    $.ajax({
                        type: 'GET',
                        url: "/event/"+id,
                        success: function (data) {
                            window.location.href = data.redirecturl;
                        },
                        error: function () {
                            alert('error happened');
                        }
                    });

                }
            };
        currentRow.onclick = createClickHandler(currentRow);
    };


}
window.onload = addRowHandlers();





