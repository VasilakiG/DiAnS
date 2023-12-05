import { chakra } from "@chakra-ui/react";
//import Footer from "../shared/footer";
import Header from "../shared/header";

type LayoutProps = {
    children: React.ReactNode;
};

const Layout = ({ children }: LayoutProps) => {

return (
    <>

    <Header />

    <chakra.main>{children}</chakra.main>
    
    {/* <Footer /> */}
    
    </>
);
};

export default Layout;