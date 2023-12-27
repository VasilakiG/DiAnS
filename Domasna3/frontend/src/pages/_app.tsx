import "../styles/globals.css";
import type { AppProps } from "next/app";
import { ChakraProvider } from "@chakra-ui/react";
import { ReactElement, ReactNode } from "react";
import { NextPage } from "next";
//import { style } from "@/styles/style";
import Script from 'next/script';

//import { DefaultSeo } from 'next-seo';
//import SEO from '../../next-seo.config';

export type NextPageWithLayout<P = {}, IP = P> = NextPage<P, IP> & {
  getLayout?: (page: ReactElement) => ReactNode;
};

type AppPropsWithLayout = AppProps & {
  Component: NextPageWithLayout;
};

export default function App({ Component, pageProps: { session, ...pageProps }}: AppPropsWithLayout) {
  const getLayout = Component.getLayout ?? ((page) => page);

  return (
    <ChakraProvider>

        {/* <DefaultSeo {...SEO}/> */}

        {getLayout(<Component {...pageProps} />)}
    </ChakraProvider>
  );
}