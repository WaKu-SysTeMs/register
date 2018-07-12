$(function () {
    
    $.extend($.fn.dataTable.defaults, {
        language: {
            url: "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
        }
    });
    $('#myTable').DataTable({
         dom:"<'row'<'col-sm-6'l><'row'<'col-sm-6'f>>" +
            "<'row'<'col-sm-12'tr>>" +
            "<'row'<'col-sm-12'i>>" + 
            "<'row'<'col-sm-12'p>>"
    });
});