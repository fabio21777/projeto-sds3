import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

function DataTable() {
    const [activePage, setActivePage] = useState(0);
    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });
    useEffect(()=>{
        axios.get(`${BASE_URL}/sales?&page=${activePage}&linesPerPage=20&orderBy=amount&direction=ASC`)
        .then(response => {
            setPage(response.data)
        })
    },[activePage])
    const changePage = (index: number) => {
        setActivePage(index);
    }

    return (
        <>
        <Pagination page = { page } onPageChange = { changePage }/>
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                {page.content?.map(item => (
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                                <td>{item.seller.name}</td>
                                <td>{item.visited}</td>
                                <td>{item.deals}</td>
                                <td>{item.amount.toFixed(2)}</td>
                            </tr>
                        ))}
                </tbody>
            </table>
        </div>
        </>
    );
}

export default DataTable;

function last<T>(first: any, arg1: boolean, last: any, arg3: boolean, number: any, arg5: number, totalElements: any, arg7: number, totalPages: any, arg9: number): [any, any] {
    throw new Error("Function not implemented.");
}
